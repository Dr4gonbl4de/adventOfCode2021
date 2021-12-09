fun main() {
    fun part1(input: List<String>): Int {
        var last: Int? = null
        val count = input.fold(0) { c, current ->
            if (last != null && last!! < current.toInt()) {
                last = current.toInt()
                c + 1
            } else {
                last = current.toInt()
                c
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val lines = input.map { it.toInt() }
        var last: Int? = null
        return lines.foldIndexed(0) { index, acc, s ->
            if (index + 2 >= lines.size) return acc
            val newValue = s + lines[index + 1] + lines[index + 2]
            if (last != null && last!! < newValue) {
                last = newValue
                acc + 1
            } else {
                last = newValue
                acc
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
