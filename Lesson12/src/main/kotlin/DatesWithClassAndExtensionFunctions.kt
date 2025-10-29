fun main() {
    var d = askQuestionAndReadInt("Insert day?")
    var m = askQuestionAndReadInt("Insert month?")
    var y = askQuestionAndReadInt("Insert year?")
    var date: Date = Date(d, m, y)

    var isValid: Boolean = date.validDate()
    var result: String = if(isValid) "" else "in"

    println("Version with data class")
    println("The given date is ${result}valid")
    var elapsedDays = date.yearElapsedDays()
    if(isValid)
        println("${elapsedDays} passed since the begining of ${y}")
}



fun Date.yearElapsedDays(): Int {
    val daysMonth = listOf<Int>(31, 28 + leapDays(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    var sumDays = day
    for(i in 1.. month-1) {
        sumDays = sumDays + daysMonth[i-1]
    }
    return sumDays
}


fun Date.validDate(): Boolean {
    return  year >= 0 &&
            month in 1..12 &&
            day in 1..
                when(month) {
                    1,3,5,7,8,10,12 -> 31
                    4,6,9,11 -> 30
                    else -> 28 + leapDays(year)
                }
}
