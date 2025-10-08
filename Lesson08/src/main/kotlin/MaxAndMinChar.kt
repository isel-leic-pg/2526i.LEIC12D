// create a program that gets a phase from the user and
// shows the char with the lowest and the highest char
// and the corresponding codes

fun main( ) {
    // 1. Ask user a phrase and read it
    println("Enter a phrase:")
    var phrase = readln()

    // 2. Create a variable (minCode) to contain the
    // lowest code found. The initial value is the char Max Value
    var minCode: Int = Char.MAX_VALUE.code + 1
    var maxCode: Int = Char.MIN_VALUE.code - 1

    // 3. Enter a cycle till the end of the string
    for(c in phrase) {
        // 3.1 For each iteration
        // 3.2 get the code from the current char
        // 3.3 if current char has lower code than minCode
        if(c.code < minCode) {
            // minCode is set to current char code
            minCode = c.code
        }
        if (c.code > maxCode) {
            maxCode = c.code
        }
    }

    println("The maximum char written was '${maxCode.toChar()}' with code $maxCode")
    println("The minimum char written was '${minCode.toChar()}' with code $minCode")

    // Print the minCode char and code

}