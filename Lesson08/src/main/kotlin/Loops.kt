fun main() {
//    // Solution 1
//    do {
//        println("What is the best team in the world?")
//        var answer = readln()
//        answer = answer.lowercase()
//    } while(answer != "benfica")
//
//    // Solution 2
//    var answer = getAnswer()
//
//    while (answer != "benfica") {
//        answer = getAnswer()
//    }

    // Solution 3
    var answer = ""
    do {
        answer = getAnswer()
    } while(answer != "benfica")

    for(c in answer) {
        println(c)
    }

    println("You are right!!!")
}

fun getAnswer() : String {
    println("What is the best team in the world?")
    var answer = readln().lowercase()
    return answer
}