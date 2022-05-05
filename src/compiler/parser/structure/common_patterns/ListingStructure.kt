package compiler.parser.structure.common_patterns

import compiler.parser.structure.TokenGroupingPattern
import compiler.tokens.patterns.TokenPattern
import compiler.tokens.patterns.operators.UnfixedOperatorPattern
import utils.patterns.ImpliedPattern
import utils.patterns.Pattern
import utils.patterns.PatternFlag

//matches to structure of pattern: "1, 2, 3, 4, 5" or "Hi, Hello, There" etc
class ListingStructure<T: TokenPattern>(listedType: Pattern<T>) : TokenGroupingPattern<T>(
    listOf(
        object : TokenGroupingPattern<T>(
            listOf(listedType, ImpliedPattern(UnfixedOperatorPattern.COMMA_OPERATOR as T))
        ) {
            override fun getFlags(): Set<Pattern.Flags> = setOf(Pattern.Flags.OPTIONAL, Pattern.Flags.REPEATABLE)
        } as Pattern<T>,
        listedType
    )
)