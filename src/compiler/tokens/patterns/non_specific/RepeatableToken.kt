package compiler.tokens.patterns.non_specific

import compiler.tokens.patterns.TokenPattern

class RepeatableToken(private val heldTokenPattern: TokenPattern): TokenPattern {
    override val matchedPattern: Regex
        get() = Regex("(" + heldTokenPattern.matchedPattern.pattern + ")+")
}