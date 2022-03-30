package compiler.tokens.patterns.non_specific

import compiler.tokens.patterns.TokenPattern

object IgnoredTokenPattern : TokenPattern {
    override val matchedPattern = Regex(" ")
}