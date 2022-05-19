package utils.patterns.feeding

import utils.miscellaneous.Copyable
import utils.patterns.Pattern

interface Acceptor<T, F: Feeder<T>>: Pattern<F>, Iterator<Pattern<T>>, Copyable<Acceptor<T, F>> {
    override fun matches(checkedValue: F): Boolean {
        while (hasNext() && checkedValue.hasNext()) {
            val nextValue = next()
            val comparedNext = checkedValue.next()

            if(nextValue.containsFlag(Pattern.Flags.OPTIONAL)) {
                if(nextValue.matches(comparedNext)) continue
                if (!next().matches(comparedNext)) return false
                continue
            }

            if(nextValue.matches(comparedNext)) return false

            if(nextValue.containsFlag(Pattern.Flags.REPEATABLE)) {
                if(copy().matches(checkedValue)) return true
                next()
            }
        }

        return !(hasNext() || checkedValue.hasNext());
    }
}