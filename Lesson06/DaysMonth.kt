fun main() {
    println("Insert month as a number between 1 and 12")
    var month = readln().toInt()
    

    var monthDays = when(month) {
        4, 6, 9, 11 -> 30
        1, 3, 5, 7, 8, 10, 12 -> 31
        else -> {
            println("Insert the year")
            val year = readln().toInt()
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 29 else 28
        }
            
    }


    println("The month $month has $monthDays days")
}