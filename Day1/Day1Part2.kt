package Day1

import java.io.File

fun main() {
    File("Day1/Day1.txt").useLines { lines ->
        countCaloriesPerElf(lines)
            .sortedDescending()
            .take(3)
            .sum()
            .also { println("Result: $it") }
    }
}