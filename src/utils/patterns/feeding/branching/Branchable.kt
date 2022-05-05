package utils.patterns.feeding.branching

interface Branchable<T> {
    fun nextSplits(): Boolean

    fun getBranches(): List<T>
}