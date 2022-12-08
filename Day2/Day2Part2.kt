package Day2

import java.io.File
import java.lang.RuntimeException

fun main() {
    File("Day2/Day2.txt").useLines { lines ->
        val result = lines
            .map { RoundPart2(it[0].toHand(), it[2].toResult()) }
            .map { it.points() }
            .sum()
        println("Total score: $result")
    }
}

data class RoundPart2(val thy: Hand, val result: Result) {

    fun points(): Int = when (result) {
        Result.DRAW -> thy.point
        Result.LOSE -> thy.lose().point
        Result.WIN -> thy.win().point
    } + result.point
}

enum class Result(val point: Int) {
    WIN(6), LOSE(0), DRAW(3)
}

fun Char.toResult(): Result = when (this) {
    'X' -> Result.LOSE
    'Y' -> Result.DRAW
    'Z' -> Result.WIN
    else -> throw RuntimeException()
}

fun Hand.lose() = when (this) {
    Hand.ROCK -> Hand.SCISSOR
    Hand.PAPER -> Hand.ROCK
    Hand.SCISSOR -> Hand.PAPER
}
