fun main() {
    println("Insert a grade between 0 and 20:")
    var grade = readln().toInt()
    if(grade > 20 || grade < 0) {
        println("Invalid value")
    } else {
        println(when {
            grade < 10 -> "Failed"
            grade in 10..13 -> "Sufficient"
            grade in 14..15 -> "Good"
            grade in 16..17 -> "Very Good"
            grade in 18..20 -> "Excellent"
            else -> "Invalid Value"
        })
    }
}