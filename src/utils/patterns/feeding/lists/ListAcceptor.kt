package utils.patterns.feeding.lists

import utils.patterns.Pattern
import utils.patterns.feeding.Acceptor
import utils.patterns.feeding.Feeder

open class ListAcceptor<T>(private val heldList: List<Pattern<T>>, startingIndex: Int = 0) : Acceptor<T, Feeder<T>> {
    val iterator = heldList.listIterator(startingIndex)

    override fun hasNext(): Boolean = iterator.hasNext()

    override fun next(): Pattern<T> = iterator.next()

    override fun copy(): ListAcceptor<T> = ListAcceptor(heldList, iterator.previousIndex())
}