package utils.miscellaneous

interface Copyable<T: Copyable<T>> {
    fun copy(): T
}