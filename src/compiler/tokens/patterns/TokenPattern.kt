package compiler.tokens.patterns

import compiler.parser.structure.AbstractTokenHolderPattern

interface TokenPattern : AbstractTokenHolderPattern<String> {
    val matchedPattern: Regex

    override fun matches(checkedValue: String): Boolean = matchedPattern.matches(checkedValue)
}