package Day5

import java.io.File

fun main() {
    File("Day5/Day5.txt").useLines { linesSeq ->
        val lines = linesSeq.toList() // saving myself a headache
        val stacks = createStacks(lines)

        lines.forEach {
            if (it.startsWith("move")) {
                val command = it.split(" ").toCommand()
                repeat(command.num) {
                    val item = stacks[command.origin - 1].removeFirst()
                    stacks[command.destination - 1].addFirst(item)
                }
            }
        }

        stacks.map { it.firstOrNull() }
            .joinToString("")
            .also { println("Result: $it") }
    }
}

fun createStacks(lines: List<String>): List<ArrayDeque<Char>> {
    val endLine = lines.withIndex().first { it.value.replace(" ", "").toIntOrNull() != null }
    val numStacks = endLine.value.toCharArray().count { it.isDigit() }
    val stacks = Array<ArrayDeque<Char>>(numStacks) { ArrayDeque() }
    lines.take(endLine.index)
        .forEach {
            it.toCharArray()
                .forEachIndexed { index, char ->
                    if (char.isLetter()) stacks[(index - 1) / 4].addLast(char)
                }
        }
    return stacks.toList()
}

data class Command(val num: Int, val origin: Int, val destination: Int)

fun List<String>.toCommand() = Command(this[1].toInt(), this[3].toInt(), this[5].toInt())
