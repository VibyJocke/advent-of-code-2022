package Day5

import java.io.File

fun main() {
    File("Day5/Day5.txt").useLines { linesSeq ->
        val lines = linesSeq.toList() // saving myself a headache
        val stacks = createStacks(lines)

        lines.forEach {
            if (it.startsWith("move")) {
                val command = it.split(" ").toCommand()
                val liftedStack = ArrayDeque<Char>()
                repeat(command.num) {
                    val item = stacks[command.origin - 1].removeFirst()
                    liftedStack.addLast(item)
                }
                repeat(command.num) {
                    stacks[command.destination - 1].addFirst(liftedStack.removeLast())
                }
            }
        }

        stacks.map { it.firstOrNull() }.joinToString("").also { println("Result: $it") }
    }
}
