package Day7

import java.io.File

fun main() {
    File("Day7/Day7.txt").useLines { lines ->
        getSizesByDirectory(lines)
            .filter { it.value <= 100000 }
            .values
            .sum()
            .also { println("Result: $it") }
    }
}

fun getSizesByDirectory(lines: Sequence<String>): Map<String, Int> {
    val sizeByDirectory = mutableMapOf<String, Int>()
    var currentDir = ""
    lines.forEach { line ->
        if (line.startsWith("$ cd")) {
            currentDir = when (line) {
                "$ cd /" -> "/"
                "$ cd .." -> currentDir.substringBeforeLast("/")
                else -> currentDir + line.replace("$ cd ", "/")
            }
        } else if (line.startsWith("dir")) {
            // Need to create empty entries so that sub-dir summarizer works correctly
            sizeByDirectory[currentDir + "/" + line.replace("dir ", "")] = 0
        } else if (!line.startsWith("$")) {
            val fileSize = line.split(" ")[0].toInt()
            if (sizeByDirectory.containsKey(currentDir)) {
                sizeByDirectory.computeIfPresent(currentDir) { _, value -> value + fileSize }
            } else {
                sizeByDirectory[currentDir] = fileSize
            }
        }
    }

    // Calculate new directory structure including the sizes of all sub-directories
    return sizeByDirectory.mapValues { outer ->
        sizeByDirectory
            .filter { it.key.startsWith(outer.key) }
            .map { it.value }
            .sum()
    }
}