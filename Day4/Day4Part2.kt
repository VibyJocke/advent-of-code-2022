package Day4

import java.io.File

fun main() {
    File("Day4/Day4.txt").useLines { lines ->
        lines.count { pair ->
            pair.split(",").map { range ->
                range.split("-").let { it.first().toInt()..it.last().toInt() }
            }.anyOverlap()
        }.also { println("Result $it") }
    }
}

fun List<IntRange>.anyOverlap(): Boolean = first().any { it in last() }