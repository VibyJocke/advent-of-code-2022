package Day1

import java.io.File

fun main() {
    File("Day1/Day1.txt").useLines { lines ->
        countCaloriesPerElf(lines)
            .max()
            .also { println("Result: $it") }
    }
}

fun countCaloriesPerElf(lines: Sequence<String>): List<Int> {
    val caloriesPerElf = mutableListOf<Int>()
    var currentValue = 0
    lines.forEach {
        if (it.isEmpty()) {
            caloriesPerElf.add(currentValue)
            currentValue = 0
        } else {
            currentValue += it.toInt()
        }
    }
    caloriesPerElf.add(currentValue)
    return caloriesPerElf
}
