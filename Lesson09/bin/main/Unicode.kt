fun main() {
    for (c in '0'..'9')
        println("$c - ${c.code}")

    for(c in "ISEL") println(c)

    for(s in listOf("ISEL","PG","IPL"))
        println(s)
}