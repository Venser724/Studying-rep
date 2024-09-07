import kotlin.random.Random

class Lotto {

    // определите поле, в котром будут храниться добавленные игроки `Person`
    // поле thrownNumbers должно хранить в себе набор выброшенных чисел.

    var thrownNumbers: MutableSet<Int> = mutableSetOf() // определите подходящую структуру данных
    var players: MutableList<Person> = mutableListOf() // определите подходящую структуру данных
    var winners: MutableList<Person> = mutableListOf()

    var wasWinner: Boolean = false

    fun addPerson(person: Person) {
        lotto.players.add(person) // добавить игрока в список игроков
    }
    fun start() {
        if (lotto.players.size < 2) {
            println("Перед началом игры необходимо добавить хотя бы двух игроков")
            return
        }
        while (lotto.wasWinner == false) {
            throwNumbers()
            checkWinners()
        }

        // вывести сообщение "Перед началом игры необходимо добавить хотя бы двух игроков" и завершить работу, если количество добавленных игроков меньше 2

        // достать номер. Номер может быть в диапазоне от 1 до 99 включительно
        // после каждого выброшенного числа удалять это число из карточек всех игроков, если такое число имеется
        // выбрасывать новые числа до тех пор, пока не определится победитель
        // побеждает тот, у кого в одном из рядов нет больше чисел. Победителей может быть более одного
        // после того как появляется победитель, для каждого победителя вывести текст "Победитель: [имя_победителя]!!!"
    }
}


var number: Int = 0
var lotto: Lotto = Lotto()




fun throwNumbers() {
    number = Random.nextInt(Person.MIN_NUMBER, Person.MAX_NUMBER)
    if (!lotto.thrownNumbers.contains(number)) {
        lotto.thrownNumbers.add(number)
        println("Выброшенное число: $number")
    } else {
        throwNumbers()
    }


    for (player in lotto.players) {
        for (line in player.card.numbers) {
            line.value.remove(number)
        }
    }
}

fun checkWinners() {
    for (player in lotto.players) {
        for (line in player.card.numbers) {
            if (line.value.isEmpty()) {
                lotto.winners.add(player)

                lotto.wasWinner = true
                break
            }
        }
    }
}


class Card(val numbers: Map<Int, MutableSet<Int>>)

class Person(val name: String) {

    val card: Card = createCard()

    private fun createCard(): Card {
        val numbers: Set<Int> = generateNumbers()

        val iterator: Iterator<Int> = numbers.iterator()
        var currentLine = 1

        val cardNumbers: MutableMap<Int, MutableSet<Int>> = mutableMapOf(
            1 to mutableSetOf(),
            2 to mutableSetOf(),
            3 to mutableSetOf()
        )

        while (iterator.hasNext()) {
            val number = iterator.next()
            cardNumbers[currentLine]?.add(number)

            if (currentLine < 3) {
                currentLine++
            } else {
                currentLine = 1
            }
        }

        return Card(cardNumbers)
    }

    private fun generateNumbers(): Set<Int> {
        val numbers: MutableSet<Int> = mutableSetOf()

        while (numbers.size < Person.NUMBERS_COUNT) {
            numbers.add(Random.nextInt(Person.MIN_NUMBER, Person.MAX_NUMBER))
        }

        return numbers
    }

    companion object {

        const val NUMBERS_COUNT = 15
        const val MAX_NUMBER = 100
        const val MIN_NUMBER = 1
    }
}