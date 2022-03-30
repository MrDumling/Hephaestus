package compiler.tokens.patterns.non_specific

import compiler.tokens.patterns.TokenPattern

object ValidName : TokenPattern {
    override val matchedPattern = Regex("(?<![0-9a-zA-Z])[a-zA-Z_][a-zA-Z0-9_]*")
}