import kotlin.random.Random

fun main() {
     //№1 list
    val list = List(10) { Random.nextInt(-10, 11) }
    println("1: Сгенерированный список: $list")
    val pair = find(list)
    if (pair != null) {
        println("1: Первая пара соседних элементов одного знака: $pair")
    } else {
        println("Соседних элементов одного знака нет.")
    }
    //№2 set
    val numbers = List(10) { Random.nextInt(-10, 11) }
    procNumbers(numbers)
    //№3 map
    println("Введите количество строк:")
    val n = readLine()?.toIntOrNull() ?: 0 //Handle non-integer input
    if (n <= 0) {
        println("Некорректное количество строк.  Программа завершена.")
        return
    }
    val lines = mutableListOf<String>()
    println("Введите строки (по одной за строкой):")
    for (i in 0 .. n) {
        val line = readLine() ?: "" //Handle null input
        lines.add(line)
    }
    val words = lines.joinToString(" ").lowercase().split("\\s+".toRegex())
    val wordCounts = mutableMapOf<String, Int>()

    for (word in words) {
        wordCounts[word] = wordCounts.getOrDefault(word, 0) + 1
    }

    var mostFrequentWord = ""
    var maxCount = 0
    for ((word, count) in wordCounts) {
        if (count > maxCount) {
            maxCount = count
            mostFrequentWord = word
        } else if (count == maxCount && word < mostFrequentWord) {
            mostFrequentWord = word
        }
    }
    println("Наиболее часто встречающееся слово: $mostFrequentWord")
}


fun find(list: List<Int>): Pair<Int, Int>? { //list
    for (i in 0 until list.size - 1) {
        if (list[i] * list[i + 1] > 0) {
            return Pair(list[i], list[i + 1])
        }
    }
    return null
}
fun procNumbers(numbers: List<Int>) {
    val seenNumbers = mutableSetOf<Int>() // Set

    for (number in numbers) {
        val result = if (seenNumbers.contains(number)) "YES" else "NO"
        println("2: $number - $result")
        seenNumbers.add(number)
    }
}

