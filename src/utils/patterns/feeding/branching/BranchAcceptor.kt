package utils.patterns.feeding.branching

import utils.miscellaneous.Copyable
import utils.patterns.Pattern
import utils.patterns.feeding.Acceptor

/*
    *
    * Acceptor  |Matched|Feeder Next   |Acceptor Next
    * ----------|-------|--------------|--------------
    * None      |False  |None          |None
    * None      |True   |Next          |Next
    * Optional  |False  |Next          |Next | Same
    * Optional  |True   |Next | Same   |Next
    * Repeated  |False  |None          |None
    * Repeated  |True   |Next          |Next | Same
    *
*/

interface BranchAcceptor<T : Pattern<U>, U> : Acceptor<T, U, BranchFeeder<U>>, Copyable<BranchAcceptor<T, U>>,
    Branchable<Acceptor<T, U, BranchFeeder<U>>> {

    override fun matches(checkedValue: BranchFeeder<U>): Boolean {
        while (hasNext() && checkedValue.hasNext()) {
            if (nextSplits() && checkedValue.nextSplits()) {
                val comparedBranches = checkedValue.getBranches()
                return getBranches().any { x ->
                    comparedBranches.any { y ->
                        x.matches(y)
                    }
                }
            }

            if (nextSplits()) return getBranches().any {
                it.matches(checkedValue.copy())
            }

            if (checkedValue.nextSplits()) {
                val comparedBranches = checkedValue.getBranches()

                if (!comparedBranches.any {
                        copy().matches(it)
                    }) return false
            } else if (!getCurrentValue().matches(checkedValue.getCurrentValue())) return false

            next()
            checkedValue.next()
        }

        return !(hasNext() || checkedValue.hasNext())
    }
}