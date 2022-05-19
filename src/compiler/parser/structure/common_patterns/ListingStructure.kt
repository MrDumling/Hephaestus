package compiler.parser.structure.common_patterns

import compiler.tokens.patterns.TokenPattern
import compiler.tokens.patterns.operators.UnfixedOperatorPattern
import utils.patterns.ImpliedPattern
import utils.patterns.Pattern
import utils.patterns.feeding.lists.ListAcceptor

//matches to structure of pattern: "1, 2, 3, 4, 5" or "Hi, Hello, There" etc
fun <T : TokenPattern> listingStructure(listedType: Pattern<T>) = ListAcceptor<T>(
    listOf(
//        ListAcceptor<T>(listOf(listedType, UnfixedOperatorPattern)),
        listedType
    )
)