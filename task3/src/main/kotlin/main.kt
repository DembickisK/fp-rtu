package kt.rtuset.empty

import kotlin.math.sqrt

/**
 * We define a set by its characteristic function
 */
typealias Set = (Int) -> Boolean

/**
 * NB!: You're allowed to use self-implemented Set functions as well
 * as `forAll()` in other function implementations
 */

/**
 * If  a set contains an element.
 */
infix fun Set.contains(elem: Int): Boolean = invoke(elem)

/**
 * Singleton set from one element
 */
fun singletonSet(elem: Int): Set = { it == elem }

/**
 * Union of the two sets
 */
infix fun Set.union(set: Set): Set = { this(it) || set(it) }

/**
 * Intersection of the two sets
 */
infix fun Set.intersect(set: Set): Set = { this(it) && set(it) }

/**
 * Difference of two given sets
 */
infix fun Set.diff(set: Set): Set = { this(it) != set(it) }

/**
 * Filter
 */
fun Set.filter(predicate: (Int) -> Boolean): Set = { predicate(it) }

/** =========== For brave enough =========== */

const val BOUND = 1000

/**
 * if  all bounded integers within s satisfy p
 */
fun Set.forAll(predicate: (Int) -> Boolean): Boolean {
    tailrec fun iterate(a: Int): Boolean =
        when {
            a > BOUND -> true
            invoke(a) and predicate(a).not() -> false
            else -> iterate(a + 1)
        }
    return iterate(-BOUND)
}

infix fun Set.exists(predicate: (Int) -> Boolean): Boolean = TODO()

fun Set.map(transform: (Int) -> Int): Set = TODO()

val Set.contents: String
    get() = TODO()

