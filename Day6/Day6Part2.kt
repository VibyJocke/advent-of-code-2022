package Day6

import java.io.File

fun main() {
    File("Day6/Day6.txt").useLines { lines ->
        lines.forEach { line ->
            line.getMarkerPosition(14).also { println("Result: $it") }
        }
    }
}
