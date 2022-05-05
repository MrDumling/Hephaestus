package compiler.tokens.patterns.non_specific

import compiler.tokens.patterns.TokenPattern

class GroupableTokens(private vararg val heldTokenPatterns: TokenPattern): TokenPattern {
    override val matchedPattern: Regex
        get() = Regex(heldTokenPatterns.joinToString{ "(" + it.matchedPattern.pattern + ")" })
}