fun main() {
    val a = readInt("A")
    val b = readInt("B")
    val c = readInt("C")
    val type = typeOfTriangle(a,b,c)
    println("O triangulo é $type")
    if ((type =="Escaleno" || type=="Isósceles") && isRectangle(a,b,c))
        println("O triângulo é rectangulo")
}

fun max(a: Int, b: Int): Int = if (a>b) a else b

fun max(a: Int, b: Int, c: Int): Int = max( max(a,b), c )

fun isRectangle(x: Int, y:Int, z:Int): Boolean {
    val h = max(x,y,z)
    val c1: Int
    val c2: Int
    when(h) {
        x -> { c1 = y; c2 = z }
        y -> { c1 = x; c2 = z }
        else -> { c1 = x; c2 = y}
    }
    return h*h == c1*c1 + c2*c2
}

fun readInt(name: String): Int {
    print("$name? ")
    return readln().toInt()
}

fun typeOfTriangle(a: Int, b: Int, c: Int) = when {
    a >= b+c || b >= a+c || c >= a+b -> "Impossível"
    a==b && b==c -> "Equilatero"
    a==b || b==c || a==c -> "Isósceles"
    else -> "Escaleno"
}