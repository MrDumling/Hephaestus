package utils.patterns

interface Pattern<T> {
    fun matches(checkedValue: T): Boolean

    enum class Flags {
        OPTIONAL,
        REPEATABLE;
    }

    fun getFlags(): Set<Flags> = setOf()

    fun containsFlag(checkedFlag: Flags): Boolean = getFlags().contains(checkedFlag)

    fun flagsEmpty(): Boolean = getFlags().isEmpty()
}