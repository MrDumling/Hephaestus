package utils.patterns

class ImpliedPattern<T>(private val matchedValue: T) : Pattern<T> {
    override fun matches(checkedValue: T) = matchedValue == checkedValue
}