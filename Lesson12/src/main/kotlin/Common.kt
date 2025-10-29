fun leapDays(year: Int) : Int =
    if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 1
    else 0


/**
 * Receives a string with a question, prints it and reads the answer
 * as in Int
 * @param question the question to ask the user
 *
 * @return the integer inserted
 */
fun askQuestionAndReadInt(question:String): Int {
    println(question)
    return readln().trim().toInt()
}
