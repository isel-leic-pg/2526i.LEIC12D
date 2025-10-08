val PI = 3.1415926

//fun circleArea(radius: Double): Double = radius * radius * PI
fun circleArea(radius: Double): Double {
    return radius * radius * PI
}

fun minimum(value1: Int, value2: Int): Int =
    if(value1 > value2) value2 else value1

fun toUpper(c: Char) : Char {

    if(!(c in 'a'..'z' ))
        return c
    return 'A' + (c - 'a')
}



fun main() {
    print("Insert circle radius:")

    val r = readln().toDouble()
    val area = circleArea(r)
    println(area)

    var ret = toUpper('c')
    println(ret)
    ret = toUpper('D')
    println(ret)

    ret = toUpper('2')
    println(ret)
}