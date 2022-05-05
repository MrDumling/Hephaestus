package compiler.parser.structure

import utils.patterns.Pattern
import utils.patterns.PatternGrouping

open class TokenGroupingPattern<T>(heldTokenPatterns: List<Pattern<T>>) :
    PatternGrouping<T>(heldTokenPatterns)