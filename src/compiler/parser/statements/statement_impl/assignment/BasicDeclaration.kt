package compiler.parser.statements.statement_impl.assignment


import compiler.parser.statements.Statement
import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.parser.statements.statement_patterns.assignment.DeclarationPattern
import compiler.tokens.TokenValue
import compiler.tokens.patterns.non_specific.ValidName

abstract class GenericDeclarationStatement(heldPattern: StatementPattern, heldValue: List<TokenValue>) :
    Statement(heldPattern, heldValue) {
    val variableName: String
        get() = heldValue.find { it.type == ValidName }?.value!!
}

class BooleanDeclarationStatement(heldValue: List<TokenValue>) :
    GenericDeclarationStatement(DeclarationPattern.BOOLEAN_DECLARATION, heldValue)

class CharacterDeclarationStatement(heldValue: List<TokenValue>) :
    GenericDeclarationStatement(DeclarationPattern.CHARACTER_DECLARATION, heldValue)

class FloatDeclarationStatement(heldValue: List<TokenValue>) :
    GenericDeclarationStatement(DeclarationPattern.FLOAT_DECLARATION, heldValue)

class IntDeclarationStatement(heldValue: List<TokenValue>) :
    GenericDeclarationStatement(DeclarationPattern.INT_DECLARATION, heldValue)

class StringDeclarationStatement(heldValue: List<TokenValue>) :
    GenericDeclarationStatement(DeclarationPattern.STRING_DECLARATION, heldValue)