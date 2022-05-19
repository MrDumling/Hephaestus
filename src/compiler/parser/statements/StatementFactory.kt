package compiler.parser.statements

import compiler.parser.statements.statement_impl.assignment.*
import compiler.parser.statements.statement_impl.flow_control.GotoStatement
import compiler.parser.statements.statement_impl.flow_control.LabelStatement
import compiler.parser.statements.statement_patterns.assignment.ArrayDeclarationPattern
import compiler.parser.statements.statement_patterns.assignment.DeclarationPattern
import compiler.parser.statements.statement_patterns.assignment.ReassignmentPattern
import compiler.parser.statements.statement_patterns.flow_control.GotoPattern
import compiler.parser.statements.statement_patterns.flow_control.LabelPattern
import compiler.tokens.TokenValue

object StatementFactory {
    fun matchesStatement(inputTokens: List<TokenValue>): Boolean = listOf(
        *DeclarationPattern.values(),
        ReassignmentPattern,
        GotoPattern,
        LabelPattern,

        *(DeclarationPattern.values().map{
            x -> ArrayDeclarationPattern(x)
        }).toTypedArray()
    ).any {
        it.matches(inputTokens)
    }

    fun buildStatement(inputTokens: List<TokenValue>): Statement = when {
        DeclarationPattern.INT_DECLARATION.matches(inputTokens) -> IntDeclarationStatement(inputTokens)
        DeclarationPattern.STRING_DECLARATION.matches(inputTokens) -> StringDeclarationStatement(inputTokens)
        DeclarationPattern.CHARACTER_DECLARATION.matches(inputTokens) -> CharacterDeclarationStatement(inputTokens)
        DeclarationPattern.BOOLEAN_DECLARATION.matches(inputTokens) -> BooleanDeclarationStatement(inputTokens)
        DeclarationPattern.FLOAT_DECLARATION.matches(inputTokens) -> FloatDeclarationStatement(inputTokens)

        ArrayDeclarationPattern(DeclarationPattern.INT_DECLARATION).matches(inputTokens) -> ArrayDeclaration(inputTokens, DeclarationPattern.INT_DECLARATION)

        ReassignmentPattern.matches(inputTokens) -> ReassignmentStatement(inputTokens)

        GotoPattern.matches(inputTokens) -> GotoStatement(inputTokens)
        LabelPattern.matches(inputTokens) -> LabelStatement(inputTokens)

        else -> throw RuntimeException("Unable to create statement of order: " + inputTokens.map {
            it.type
        })
    }
}