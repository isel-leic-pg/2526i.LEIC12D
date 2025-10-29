fun main() {
    var d = askQuestionAndReadInt("Insert day?")
    var m = askQuestionAndReadInt("Insert month?")
    var y = askQuestionAndReadInt("Insert year?")

    var date: Date = Date(d, m, y)


    var isValid: Boolean = validDate(date)
    var result: String = if(isValid) "" else "in"

    println("Version with data class")
    println("The given date is ${result}valid")
    var elapsedDays = yearElapsedDays(date)
    if(isValid)
        println("${elapsedDays} passed since the begining of ${y}")
}


data class Date(val day: Int, val month: Int, val year: Int)

fun yearElapsedDays(date: Date): Int {
    val daysMonth = listOf<Int>(31, 28 + leapDays(date.year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    var sumDays = date.day
    for(i in 1.. date.month-1) {
        sumDays = sumDays + daysMonth[i-1]
    }
    return sumDays
}


fun validDate(date: Date): Boolean {
    return  date.year >= 0 &&
            date.month in 1..12 &&
            date.day in 1..
                when(date.month) {
                    1,3,5,7,8,10,12 -> 31
                    4,6,9,11 -> 30
                    else -> 28 + leapDays(date.year)
                }
}


