package compiler.parser.statements.statement_patterns.miscellaneous

import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.parser.structure.TokenGroupingPattern
import compiler.parser.structure.TokenStructurePattern
import compiler.tokens.patterns.non_specific.StatementEndTokenPattern

object EmptyStatementPattern: StatementPattern {
    override val tokenPattern = TokenGroupingPattern(StatementEndTokenPattern)
}