package compiler.tokens.patterns.non_specific

import compiler.tokens.patterns.TokenPattern

class OptionalToken(private val heldTokenPattern: TokenPattern): TokenPattern {
    override val matchedPattern: Regex
        get() = Regex("(" + heldTokenPattern.matchedPattern.pattern + ")?")
}