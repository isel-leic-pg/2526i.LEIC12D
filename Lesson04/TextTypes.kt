fun main() {
    var c1: Char = 'z'
    var c1Position: Int = c1 - 'a' + 1
    println("A posição do $c1 no alfabeto é $c1Position")

    var i1 = 122
    var i2 = 1
    println(i1 + i2)

    var s1 = "122"
    var s2 = "1"
    println(s1 + s2)

    var name = "Maria"
    var brother = "João"
    println("\\O nome é \"$name\" \ne o seu irmão é o \"$brother\"\\")


    var i = 122    
    println(i.toString())
    println(i.toString(2))
    println(i.toString(16))
    var str: String = "Na base 7 é ${i.toString(7)}"

    println("A string $str tem ${str.length} caracteres")
    println(str[0])
    println(str[str.length-1])

    var unknownStr = "A"

    var middleCharPosition: Int =  unknownStr.length / 2
    var middleChar = unknownStr[middleCharPosition]

    println("Char in the middle is $middleChar")


    str = "0x123ab"

    var number = str.toInt()
    println(number)    


}

