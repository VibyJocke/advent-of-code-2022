package Day6

import java.io.File

fun main() {
    File("Day6/Day6.txt").useLines { lines ->
        lines.forEach { line ->
            line.getMarkerPosition(4).also { println("Result: $it") }
        }
    }
}

fun String.getMarkerPosition(markerLength: Int) = toList()
    .windowed(markerLength)
    .takeWhile { it.distinct().size != markerLength }
    .count() + markerLength
