fun main() {
    var i: Int = 122 
    var b: Int = 0b0111_1010 
    var h: Int = 0X7A

    println(i)
    println(b)
    println(h)


    var s: UByte = 260.toUByte() // 0b0000_0001_0000_0001 
    println(s)

    var v1: Int = 7
    var v2: Int = 2

    var v3 = v1 / v2
    var v4 = v1 % v2

    println("Divisão inteira de $v1 por $v2: ")
    println("Quociente= " + v3)
    println("Resto= " + v4)

    var v5: Int = Int.MAX_VALUE + 1U
    println(v5)
    var v6 = Int.MIN_VALUE
    println(v6)

    var f = 3+.5*2F
    //println(f.getType())

    0x00 41. (0b 0000_0000 0100_0001). 65 
}