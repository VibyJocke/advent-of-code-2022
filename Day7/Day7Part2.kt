package Day7

import java.io.File

fun main() {
    File("Day7/Day7.txt").useLines { lines ->
        val recursiveSizesByDirectory = getSizesByDirectory(lines)

        val cleanupThreshold =
            MINIMUM_UNUSED_DISK_SPACE - (TOTAL_DISK_SPACE - recursiveSizesByDirectory["/"]!!)

        recursiveSizesByDirectory
            .filter { it.value >= cleanupThreshold }
            .minOf { it.value }
            .also { println("Result: $it") }
    }
}

private const val TOTAL_DISK_SPACE = 70000000
private const val MINIMUM_UNUSED_DISK_SPACE = 30000000