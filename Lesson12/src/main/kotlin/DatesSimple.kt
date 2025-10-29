fun main() {
    var d = askQuestionAndReadInt("Insert day?")
    var m = askQuestionAndReadInt("Insert month?")
    var y = askQuestionAndReadInt("Insert year?")

    var isValid: Boolean = validDate(d, m, y)
    var result: String = if(isValid) "" else "in"

    println("Simple version")
    println("The given date is ${result}valid")
    var elapsedDays = yearElapsedDays(d, m, y)
    if(isValid)
        println("${elapsedDays} passed since the begining of ${y}")
}

fun yearElapsedDays(d: Int, m: Int, y: Int): Int {
    val daysMonth = listOf<Int>(31, 28 + leapDays(y), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    var sumDays = d
    for(i in 1.. m-1) {
        sumDays = sumDays + daysMonth[i-1]
    }
    return sumDays
}


fun validDate(day: Int, month: Int, year: Int): Boolean {
    return  year >= 0 &&
            month in 1..12 &&
            day in 1..
                when(month) {
                    1,3,5,7,8,10,12 -> 31
                    4,6,9,11 -> 30
                    else -> 28 + leapDays(year)
                }
}


