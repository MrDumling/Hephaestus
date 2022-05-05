package compiler.tokens.patterns.non_specific

import compiler.tokens.patterns.TokenPattern

class InterchangeableTokens(private vararg val heldTokenPatterns: TokenPattern): TokenPattern {
    override val matchedPattern: Regex
        get() = Regex(heldTokenPatterns.joinToString(separator = "|") { "(" + it.matchedPattern.pattern + ")" })
}