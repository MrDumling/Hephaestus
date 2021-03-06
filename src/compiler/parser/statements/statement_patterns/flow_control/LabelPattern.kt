package compiler.parser.statements.statement_patterns.flow_control

import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.tokens.patterns.non_specific.ValidName
import compiler.tokens.patterns.operators.UnfixedOperatorPattern

object LabelPattern: StatementPattern {
    override val tokenPattern = TokenGroupingPattern(ValidName, UnfixedOperatorPattern.COLON_OPERATOR)
}