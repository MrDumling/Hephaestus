package utils.patterns.feeding.lists

import utils.patterns.feeding.Feeder

class ListFeeder<T>(private val heldList: List<T>): Feeder<T> {
    val iterator = heldList.iterator()

    override fun hasNext(): Boolean = iterator.hasNext()

    override fun next(): T = iterator.next()
}