fun main() {
    println("Insert an integer value: ")
    val n = readln().toInt()

    var result = when {
            n < 0 -> "Negative"
            n % 2 == 0 -> "Even"
            else -> "Odd"
        }
    
    println(result)
}