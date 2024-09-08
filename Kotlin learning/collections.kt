//val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
//for (i in numbers) {
//    println("Таблица умножения на $i:")
//    for (j in 1..10) {
//        println("$i * $j = ${i * j}")
//    }
//}


val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
numbers.forEach{println("Таблица умножения на $it:")}.forEach{item -> println($it * $j)}
