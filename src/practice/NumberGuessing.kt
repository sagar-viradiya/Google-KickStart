package practice

import java.util.*

object Result {
    const val TOO_SMALL = "TOO_SMALL"
    const val TOO_BIG = "TOO_BIG"
    const val CORRECT = "CORRECT"
    const val WRONG_ANSWER = "WRONG_ANSWER"
}

fun main() {
    val scanner = Scanner(System.`in`)
    var testCases = scanner.nextInt()
    while (testCases != 0) {
        if (binarySearch(scanner, scanner.nextInt() + 1, scanner.nextInt(), scanner.nextInt()) == -1) {
            break
        }
        testCases--
    }
}

fun binarySearch(scanner: Scanner, low: Int, high: Int, tries: Int): Int {
    if (tries == 0) return -1
    val mid = (low + high) / 2
    println(mid)
    return when(scanner.next()) {
        Result.TOO_SMALL -> binarySearch(scanner, mid + 1, high, tries - 1)
        Result.TOO_BIG -> binarySearch(scanner, low, mid - 1, tries - 1)
        Result.CORRECT -> 0
        Result.WRONG_ANSWER -> -1
        else -> -1
    }
}