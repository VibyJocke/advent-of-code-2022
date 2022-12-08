package Day2

import java.io.File

fun main() {
    File("Day2/Day2.txt").useLines { lines ->
        lines.sumOf {
            Round(it[0].toHand(), it[2].toHand()).points()
        }.also { println("Result: $it") }
    }
}

data class Round(val thy: Hand, val my: Hand) {
    fun points(): Int = when {
        my == thy.win() -> 6
        thy == my -> 3
        else -> 0
    } + my.point
}

enum class Hand(val point: Int) {
    ROCK(1), PAPER(2), SCISSOR(3)
}

fun Hand.win() = when (this) {
    Hand.ROCK -> Hand.PAPER
    Hand.PAPER -> Hand.SCISSOR
    Hand.SCISSOR -> Hand.ROCK
}

fun Char.toHand(): Hand = when (this) {
    'A', 'X' -> Hand.ROCK
    'B', 'Y' -> Hand.PAPER
    'C', 'Z' -> Hand.SCISSOR
    else -> throw RuntimeException()
}
