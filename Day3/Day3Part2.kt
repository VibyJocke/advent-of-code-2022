package Day3

import java.io.File

fun main() {
    File("Day3/Day3.txt").useLines { lines ->
        lines.chunked(3).sumOf { groupRucksacks ->
            groupRucksacks[0].toSet()
                .intersect(groupRucksacks[1].toSet())
                .intersect(groupRucksacks[2].toSet())
                .first()
                .getPrio()
        }.also { println("Result: $it") }
    }
}