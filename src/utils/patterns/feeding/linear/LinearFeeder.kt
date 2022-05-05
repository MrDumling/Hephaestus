package utils.patterns.feeding.linear

import utils.patterns.feeding.Feeder

class LinearFeeder<T>(matchedList: List<T>) : Feeder<T> {
    private val iterator: Iterator<T> = matchedList.iterator()
    private var currentValue: T? = null

    override fun hasNext(): Boolean = iterator.hasNext()

    override fun next(): T {
        currentValue = iterator.next()
        return currentValue!!
    }

    override fun getCurrentValue(): T = currentValue!!
}