fun main() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = (prefix + "/" + id) + "/" + actions.map{x -> x}
    println(urls)
}