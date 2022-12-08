package Day2

import java.io.File
import java.lang.RuntimeException

fun main() {
    File("Day2/Day2.txt").useLines { lines ->
        val result = lines
            .map { Round(it[0].toHand(), it[2].toHand()) }
            .map { it.points() }
            .sum()
        println("Total score: $result")
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
