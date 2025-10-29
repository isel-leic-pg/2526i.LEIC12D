// Arguments with default values
fun f1(a: Int, b: Int, c: Char = 'a') : Int {
    if(a > 5) {
        println(a)
    } else {
        println(a*2)
    }
   println(b)
   println(c+2)

    val res = a + b + (c-'a')
    return res
}

fun f2(a: Int, b: Char): Int {
    return a + b.code
}

fun f3(a: Int, c: Char, f: (Int, Char) -> Int) : Int {
    val res = f(a, c)
    return res
}

fun f4(f: (Int, Char) -> Int) : Int {
    val res = f(1, 'b')
    return res
}

//fun filter(list: List<Int>, criteria: (Int)-> Boolean) : List<Int> {
//    var l = emptyList<Int>()
//    for (e in list) {
//        if(criteria(e)){
//            l += e
//        }
//    }
//    return l
//}


fun main() {
    f1(1,2,'b')
    // Named parameter
    var i: Int = 1

    f1(i, i+2)

//    val f: (Int, Char) -> Int = {
//        a, b -> a+b.code
//    }

    f3(2, 'b') { a, b -> a+b.code }
    f4 { a, b -> a+b.code }

    var l = listOf<Int>(1,2,3,4,5,10,13,20,25,55)

    //var filterEven: (Int) -> Boolean =
    val lEven = l.filter( { e -> e % 2 == 0 })
    val lOdd = l.filter { it % 2 != 0 }
    val lBetween0And20 = l.filter( { e -> e in 0..20})
}

