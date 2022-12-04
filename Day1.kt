import java.io.File

fun main() {
    File("Day1.txt").useLines { lines ->
        val result = countCaloriesPerElf(lines)
        println("Part 1: " + result.max())
        println("Part 2: " + result.sortedDescending().take(3).sum())
    }
}

private fun countCaloriesPerElf(lines: Sequence<String>): List<Int> {
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
