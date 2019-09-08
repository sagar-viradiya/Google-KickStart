package kickstart2019.RoundA

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val testCases = scanner.nextInt()

    var n: Int
    var p: Int
    var list: MutableList<Int>
    var prefixSum: Int
    var minHours: Int

    for (i in 0 until testCases) {
        n = scanner.nextInt()
        p = scanner.nextInt()
        list = mutableListOf()
        for (j in 0 until n) {
            list.add(scanner.nextInt())
        }
        list.sortDescending()
        prefixSum = list.take(p).sum()
        minHours = (p * list[0]) - prefixSum
        for (k in 1..n-p) {
            prefixSum = prefixSum - list[k - 1] + list[k + p - 1]
            minHours  = minOf(minHours, (p * list[k]) - prefixSum)
        }
        println("Case #$i: $minHours")
    }
}