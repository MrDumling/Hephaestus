package utils.iterators

import utils.miscellaneous.Copyable

interface IndexedIterator<T>: Iterator<T>, Copyable {
    fun getIndex(): Int

    override fun copy(): IndexedIterator<T>
}