fun main() {
    println("Insert an integer value: ")
    val n = readln().toInt()
    println(when(n) {
        0,-1 -> "A"
        in 1..10 -> "B"
        !in 15..20 -> "C"
        else -> "D" 
    })
}