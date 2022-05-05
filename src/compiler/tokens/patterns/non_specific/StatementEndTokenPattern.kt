package compiler.tokens.patterns.non_specific

import compiler.tokens.patterns.TokenPattern

object StatementEndTokenPattern : TokenPattern {
    override val matchedPattern = Regex("[\\n;]")
}