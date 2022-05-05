package compiler.parser.statements.statement_patterns.assignment

import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.parser.structure.TokenGroupingPattern
import compiler.tokens.patterns.non_specific.ValidName
import compiler.tokens.patterns.operators.UnfixedOperatorPattern
import compiler.tokens.patterns.values.ImmutableValues

object ReassignmentPattern : StatementPattern {
    override val tokenPattern = TokenGroupingPattern(
        ValidName,
        UnfixedOperatorPattern.ASSIGNMENT_OPERATOR,
        InterchangeableTokens(*ImmutableValues.values())
    )
}