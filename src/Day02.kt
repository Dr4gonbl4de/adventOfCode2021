fun main() {
    fun part1(input: List<String>): Int {
        val coordinates = input.fold(Pair(0, 0)) { acc, value ->
            var horizontalPosition = 0
            var depth = 0

            val splitValues = value.split(" ")
            val direction = splitValues.component1()
            val steps = splitValues.component2().toInt()

            when (direction) {
                "forward" -> horizontalPosition += steps
                "down" -> depth += steps
                "up" -> depth -= steps
            }

            Pair(acc.first + horizontalPosition, acc.second + depth)
        }

        return coordinates.first * coordinates.second
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        val coordinates = input.fold(Pair(0, 0)) { acc, value ->
            var horizontalPosition = 0
            var depth = 0

            val splitValues = value.split(" ")
            val direction = splitValues.component1()
            val steps = splitValues.component2().toInt()

            when (direction) {
                "forward" -> {
                    horizontalPosition += steps
                    depth += (aim * steps)
                }
                "down" -> aim += steps
                "up" -> aim -= steps
            }

            Pair(acc.first + horizontalPosition, acc.second + depth)
        }

        return coordinates.first * coordinates.second
    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
