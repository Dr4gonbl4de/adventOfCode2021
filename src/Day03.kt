fun main() {
    fun part1(input: List<String>): Int {
        val columnSums = Array(input[0].length) { 0 }
        input.map {
            it.forEachIndexed() { index, value ->
                columnSums[index] += value.toString().toInt()
            }
        }

        val rates = columnSums.fold(Pair("", "")) { acc, value ->
            if (value > (input.size / 2)) Pair(acc.first + "1", acc.second + "0")
            else Pair(acc.first + "0", acc.second + "1")
        }

        val gammaRate = Integer.parseInt(rates.first, 2)
        val epsilonRate = Integer.parseInt(rates.second, 2)

        return gammaRate * epsilonRate
    }

    fun part2(input: List<String>): Int {
        val columnSums = Array(input[0].length) { 0 }
        input.map {
            it.forEachIndexed() { index, value ->
                columnSums[index] += value.toString().toInt()
            }
        }

        columnSums.forEach { print("$it - ") }
        print("\n")

        val rates = columnSums.fold(Pair("", "")) { acc, value ->
            if (value >= (input.size / 2)) Pair(acc.first + "1", acc.second + "0")
            else Pair(acc.first + "0", acc.second + "1")
        }

        println(rates)

        var oxygenRating: List<String> = input
        var co2ScrubberRating: List<String> = input
        for (i in 0..columnSums.size) {
            if (oxygenRating.size > 1) {
                oxygenRating = oxygenRating.filter { it[i] == rates.first[i] }
            }
            if (co2ScrubberRating.size > 1) {
                co2ScrubberRating = co2ScrubberRating.filter { it[i] == rates.second[i] } //Not working correctly if size 0
            }
            println("${oxygenRating.size} - ${co2ScrubberRating.size}")

            if (oxygenRating.size == 1 && co2ScrubberRating.size == 1) break
        }

        val oxygenRatingValue = Integer.parseInt(oxygenRating[0], 2)
        val co2ScrubberRatingValue = Integer.parseInt(co2ScrubberRating[0], 2)

        return oxygenRatingValue * co2ScrubberRatingValue
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
