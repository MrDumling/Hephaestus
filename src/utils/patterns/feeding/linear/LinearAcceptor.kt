package utils.patterns.feeding.linear

import utils.patterns.Pattern
import utils.patterns.feeding.Acceptor
import utils.patterns.feeding.Feeder

class LinearAcceptor<T : Pattern<U>, U>(matchedList: List<T>) : Acceptor<T, U, Feeder<U>> {
    private val iterator: Iterator<T> = matchedList.iterator()
    private var currentValue: T? = null

    override fun hasNext(): Boolean = iterator.hasNext()

    override fun next(): T {
        currentValue = iterator.next()
        return currentValue!!
    }

    override fun getCurrentValue(): T = currentValue!!
}