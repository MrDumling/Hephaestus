package utils.patterns.feeding.branching

import utils.miscellaneous.Copyable
import utils.patterns.feeding.Feeder

interface BranchFeeder<T> : Feeder<T>, Copyable<BranchFeeder<T>>, Branchable<BranchFeeder<T>>