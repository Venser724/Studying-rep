import kotlin.random.Random
import kotlin.collections

class Lotto {
    var playerList: MutableList<Person> = mutableListOf()
     // определите поле, в котром будут храниться добавленные игроки `Person`
     // поле thrownNumbers должно хранить в себе набор выброшенных чисел.
    val thrownNumbers: HashSet<Int> = hashSetOf() // определите подходящую структуру данных

    fun addPerson(person: Person) {
         playerList.add(person) // добавить игрока в список игроков
    }

    fun start() {
        while(true) {
            if (playerList.size < 2) {
                println("Перед началом игры необходимо добавить хотя бы двух игроков")
                break
            }
            playerList.forEach { person ->
                val card = person.createCard()
        }

        while(WAS_WINNER == false) {
            thrownNumber()
            chechWin(playerList)
        }
         // вывести сообщение "Перед началом игры необходимо добавить хотя бы двух игроков" и завершить работу, если количество добавленных игроков меньше 2

         // достать номер. Номер может быть в диапазоне от 1 до 99 включительно
         // после каждого выброшенного числа удалять это число из карточек всех игроков, если такое число имеется
         // выбрасывать новые числа до тех пор, пока не определится победитель
         // побеждает тот, у кого в одном из рядов нет больше чисел. Победителей может быть более одного
         // после того как появляется победитель, для каждого победителя вывести текст "Победитель: [имя_победителя]!!!"
    }
}

class Card(val numbers: Map<Int, MutableSet<Int>>)

class Person(val name: String) {

    val card: Card = createCard()

    fun createCard(): Card {
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

    fun generateNumbers(): Set<Int> {
        val numbers: MutableSet<Int> = mutableSetOf()

        while (numbers.size < NUMBERS_COUNT) {
            numbers.add(Random.nextInt(MIN_NUMBER, MAX_NUMBER))
        }

        return numbers
    }

fun thrownNumber() {
    val number = Random.nextInt(MIN_NUMBER, MAX_NUMBER)
    thrownNumbers.add(number)
    println("Выброшенное число: $number")
    personList.forEach { person ->
        person.card.numbers.forEach { (key, value) ->
            if (value.contains(number)) {
                person.card.numbers[key]?.remove(number)
            }
        }
    }
}

    fun chechWin(personList: List<Person>) {
        personList.forEach { person ->
        if (person.card.numbers[1]?.size == 0 || person.card.numbers[2]?.size == 0 || person.card.numbers[3]?.size == 0) {
            println("Победитель: ${person.name}!!!")
            WAS_WINNER = true
        }
    }

    private companion object {

        private const val NUMBERS_COUNT = 15
        private const val MAX_NUMBER = 100
        private const val MIN_NUMBER = 1
    }
}