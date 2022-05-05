package utils.patterns.feeding

import utils.patterns.Pattern

interface Acceptor<T : Pattern<U>, U, F : Feeder<U>> : Iterator<T>, Pattern<F> {
    override fun matches(checkedValue: F): Boolean {
        while (hasNext() && checkedValue.hasNext()) {
            if (!next().matches(checkedValue.next())) return false;
        }

        return !(hasNext() || checkedValue.hasNext());
    }

    fun getCurrentValue(): T
}