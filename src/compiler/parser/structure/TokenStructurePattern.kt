package compiler.parser.structure

abstract class TokenStructurePattern(vararg val heldTokenPatterns: AbstractTokenHolderPattern<*>) :
    AbstractTokenHolderPattern<AbstractTokenHolderPattern<*>>