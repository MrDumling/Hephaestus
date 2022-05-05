package utils.patterns

import utils.patterns.feeding.branching.BranchAcceptor
import utils.patterns.feeding.branching.Branchable

open class PatternGrouping<T>(val values: List<Pattern<T>>) : BranchAcceptor<Pattern<T>, T> {
    private var index = 0

    private constructor(values: List<Pattern<T>>, index: Int) : this(values) {
        this.index = index
    }

    override fun copy(): BranchAcceptor<Pattern<T>, T> {
        return PatternGrouping(values, index)
    }

    override fun hasNext(): Boolean {
        return index < values.size
    }

    override fun next(): Pattern<T> {
        return values[++index]
    }

    override fun getCurrentValue(): Pattern<T> {
        return values[index]
    }

    override fun nextSplits(): Boolean {
        return values[index + 1] is Branchable<*>
    }

    override fun getBranches(): List<BranchAcceptor<Pattern<T>, T>> {
        TODO("Not yet implemented")
    }
}