fun main() {
    println("Insert an integer value: ")
    val n = readln().toInt()
    
    var result: String
    if(n > 0)  
    {
        result = "Positive"
    } 
    else 
    {
        result = if(n == 0) "Zero" else "Negative"
        
    }

    println(result)
    
    println("Program ends")
}