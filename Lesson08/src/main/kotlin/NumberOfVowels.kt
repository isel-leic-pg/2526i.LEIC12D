// create a program that asks the user a phrase and
// presents the number of vowels of thar phrase

fun main() {
    println("Enter a phrase:")
    var phrase = readln()
    val vowels = "aeiouAEIOU"
    var countVowels = 0

    for(c in phrase) {
        if(c in vowels) {
            ++countVowels
            var x = ++countVowels
        }
    }

    println("The phrase has $countVowels vowels")
}