package Day3

import java.io.File

fun main() {
    File("Day3/Day3.txt").useLines { lines ->
        lines.sumOf {
            val compartments = it.chunked(it.length / 2)
            compartments.first().toSet()
                .intersect(compartments.last().toSet())
                .first()
                .getPrio()
        }.also { println("Result: $it") }
    }
}

fun Char.getPrio() = if (isUpperCase()) code - 38 else code - 96