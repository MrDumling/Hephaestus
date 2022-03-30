package compiler.parser.statements.statement_patterns.flow_control

import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.parser.structure.TokenGroupingPattern
import compiler.parser.structure.TokenStructurePattern
import compiler.tokens.patterns.Keyword
import compiler.tokens.patterns.non_specific.ValidName

object GotoPattern : StatementPattern {
    override val tokenPattern: TokenStructurePattern = TokenGroupingPattern(Keyword.GOTO_KEYWORD, ValidName)
}