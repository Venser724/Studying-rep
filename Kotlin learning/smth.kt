fun fun main() {
    val readOnlyMapOfFruits: map<String, Int> = mapOf("apple" to 50, "banana" to 20, "kiwi" = 40)
    println(readOnlyMapOfFruits)
}
println(readOnlyMapOfFruits("kiwi"))