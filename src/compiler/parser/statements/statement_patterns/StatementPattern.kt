package compiler.parser.statements.statement_patterns

import compiler.parser.structure.TokenGroupingPattern
import compiler.parser.structure.TokenStructurePattern
import compiler.tokens.TokenValue
import utils.patterns.Pattern

interface StatementPattern : Pattern<List<TokenValue>> {
    override fun matches(checkedValue: List<TokenValue>): Boolean {
        val matchedGroup = TokenGroupingPattern(* checkedValue.map { y -> y.type }.toTypedArray())
        if (tokenPattern.matches(matchedGroup)) return true

        return tokenPattern == matchedGroup
    }

    val tokenPattern: TokenStructurePattern
}