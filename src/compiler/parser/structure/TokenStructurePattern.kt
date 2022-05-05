package compiler.parser.structure

import utils.patterns.Pattern

abstract class TokenStructurePattern<T>(vararg val heldTokenPatterns: Pattern<T>) : Pattern<T>