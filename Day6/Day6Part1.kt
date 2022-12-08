package Day6

import java.io.File

fun main() {
    File("Day6/Day6.txt").useLines { lines ->
        lines.forEach { line ->
            line.getMarkerPosition(4).also { println("Result $it") }
        }
    }
}

fun String.getMarkerPosition(numDistinctChars: Int) = toCharArray().toList()
    .windowed(numDistinctChars, 1)
    .takeWhile { it.toSet().size != numDistinctChars }
    .count() + numDistinctChars
