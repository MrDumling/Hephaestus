package compiler.parser.statements.statement_patterns.assignment

import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.parser.structure.common_patterns.ListingStructure
import compiler.tokens.patterns.TokenPattern
import compiler.tokens.patterns.non_specific.GroupableTokens
import compiler.tokens.patterns.non_specific.InterchangeableTokens
import compiler.tokens.patterns.non_specific.ValidName
import compiler.tokens.patterns.operators.UnfixedOperatorPattern

class ArrayDeclarationPattern(inputPattern: DeclarationPattern): StatementPattern {
    override val matchedPattern: Regex = GroupableTokens(
        inputPattern.typeName as TokenPattern,
        UnfixedOperatorPattern.OPENING_BRACKET,
        UnfixedOperatorPattern.CLOSING_BRACKET,
        ValidName,
        UnfixedOperatorPattern.ASSIGNMENT_OPERATOR,

        UnfixedOperatorPattern.OPENING_BRACE,

        InterchangeableTokens(inputPattern.assignedValue, ListingStructure(inputPattern.assignedValue)),

        UnfixedOperatorPattern.CLOSING_BRACE
    ).matchedPattern
}