package utils.patterns.feeding

interface Feeder<T> : Iterator<T> {
    fun getCurrentValue(): T
}