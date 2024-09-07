import kotlin.math.abs





// реализуйте функцию average()
// average(1, 4, 4) -> Результат 3
fun average(vararg ints: Int): Double {
    
    var sum = 0.0
    for (num in ints) {
        sum += num
    }
    val average = sum / ints.size
    return average
}

fun longestWord(vararg strings: String): String {
    var longestString = ""
    for (string in strings) {
        if (string.length > longestString.length) {
            longestString = string
        }
    }
    return longestString
}
// реализуйте функцию longestWord()
// longestWord("Я", "люблю", "гулять") -> Результат "гулять"
fun nearestNumber(num: Int, vararg arrayOfNumbers): Int {
    var nearest = num
    for(n in arrayOfNumbers) {
        if(abs(num - n) < abs(nearest - n)) {
            nearest = n
        }
    }
    return nearest
}
// реализуйте функцию nearestNumber()
// nearestNumber(10, 4, 12, 9) -> Результат 9