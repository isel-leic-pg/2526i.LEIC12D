fun main() {
    var c = 'A'
    do {
        println("$c - ${c.code}")
        c += 1
    } while( c <= 'Z')


    val txt = "ISEL_PG"
    var idx = 0
    do {
        println("${txt[idx]}")
        idx += 1
    } while (idx < txt.length)
}