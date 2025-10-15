/**
 * The main entry point of the program that contains the logic
 * of the Hangman Game
 */
fun main() {
    // Flag that indicates if the game ended or not
    var gameEnded = false
    // The word the player must guess
    var wordToGuess = getRandomWord()
    println(wordToGuess)

    // String with the current word guesses.
    // The already guessed chars are visible.
    // The others are represented by '_'
    var currentWord = getUnfilledWord(wordToGuess.length)

    // The current hangman stage (or level)
    var stage = 0
    do {
        printHangman(stage, currentWord)
        val c = askChar()
        if(c in wordToGuess) {
            currentWord = revealChar(c, currentWord, wordToGuess)
        } else {
            stage++
            if(stage == hangmanStages.count())
                gameEnded = true;
        }
    } while (!gameEnded && wordToGuess != currentWord)
    if(!gameEnded) {
        println("Congratulations, You won!")
    } else {
        println("Sorry, try again...")
    }
}

/**
 * Returns a random word from words list
 */
fun getRandomWord(): String {
//    var wordPos = (0..words.count()).random()
//    return words[wordPos]
    return words.random()
}

/**
 * Receives a given length and returns a string with all chars hidden.
 * Hidden chars are represented by '_' char.
 *
 * @param length the length of the hidden word to return
 * @return the hidden string consisting of '_' repeated length times
 */
fun getUnfilledWord(length: Int): String {
//    var str = ""
//    for(i in 1..length)
//        str += '_'
//    return str
    return "_".repeat(length)
}

/**
 * Prints to the console the hangman in the given stage and
 * after prints the currentWord
 *
 * @param stage the current hangman stage
 * @param currentWord the current word state to print
 */
fun printHangman(stage: Int, currentWord: String)  {
    println(hangmanStages[stage])
    println(currentWord)
}

/**
 * Prompts the user a new char, waits for his input and returns the
 * first char the user inserted in the console
 *
 * @return the char written in the console by teh user
 */
fun askChar(): Char {
    println("Give me a character:")
    return readln()[0]
}


/**
 * Receives a char 'c', the 'currentWord' and the 'wordToGuess'.
 * Creates a new string consisting of the chars in the 'currentWord'
 * in the same positions, that are not equal to 'c', and the reveal
 * the 'c' char in the positions where it exists in 'wordToGuess'
 *
 * @param c the char to reval (if it exists in 'wordToGuess')
 * @param currentWord the current word in the hangman game
 * @param wordToGuess the word thar must be guessed
 *
 * @return the new currentWord
 */
fun revealChar(c: Char, currentWord: String, wordToGuess: String): String {
    // newCurrentWord = ""
    // i = 0
    // newCurrentWord = "v"
    // i = 1
    // newCurrentWord = "ve"
    // i = 2
    // newCurrentWord = "ve_"
    // ....
    // i = 4
    // newCurrentWord = "v___e"
    // ....
    var newCurrentWord = ""
    for(i in 0..< wordToGuess.length) {
        if(c == wordToGuess[i]) {
            newCurrentWord += c
        } else {
            newCurrentWord += currentWord[i]
        }
    }
    return newCurrentWord
}

/**
 * A string list with the char art for each hangman stage
 */
val hangmanStages = listOf(
    """
      +---+
      |   |
          |
          |
          |
          |
    =======""",
    """
      +---+
      |   |
      O   |
          |
          |
          |
    =======""",
    """
      +---+
      |   |
      O   |
      |   |
          |
          |
    =======""",
    """
      +---+
      |   |
      O   |
     /|   |
          |
          |
    =======""",
    """
      +---+
      |   |
      O   |
     /|\  |
          |
          |
    =======""",
    """
      +---+
      |   |
      O   |
     /|\  |
     /    |
          |
    =======""",
    """
      +---+
      |   |
      O   |
     /|\  |
     / \  |
          |
    ======="""
)

/**
 * The list of words to select one for a game
 */
val words = listOf(
    "árvore", "montanha", "floresta", "estrela", "chuva", "relógio", "telescópio", "amarelo", "cinzento",
    "coragem!", "vermelho", "balanço", "clássico", "tomate", "escovar", "espelho", "janela", "sabão",
    "paciente", "avançado", "saudade", "desenrascanço", "pássaro", "carneiro", "galinha", "vaca", "cavalo",
    "coração", "ventania", "nuvem", "coruja", "leopardo", "girafa", "canguru", "berço", "costela",
    "espaguete", "parágrafo", "bolacha", "armário", "cadeira", "caneta", "maravilha", "fantástico!",
    "casaco", "garrafa", "borboleta", "corredor", "chiclete", "abacaxi", "abóbora", "carvalho", "barulho",
    "peixinho", "manjericão", "molécula", "prateleira", "elhovo", "palhaço", "lempada", "regresso",
    "confiança", "sapato", "missão", "carroça", "teclado", "esquerda", "direita", "ascensor", "bolacha",
    "foguete", "união", "felicidade", "disquete", "patrulha", "bicicleta", "ventilador", "parque",
    // ... add more words to reach 256 ...
    "abundância", "fascinado", "compaixão", "delicado", "camisola", "laboratório", "canção", "pavimento",
    "depressa!", "amistoso", "gargalhada", "avental", "cenoura", "abruptamente!", "iluminação", "formiga",
    "relação", "fantasma", "esmeralda", "bufete", "quebra-cabeça", "comboio", "parênteses", "aspas",
    "reticências", "divisão", "ponto-e-vírgula", "colonização", "expressão", "geografia", "professor",
    "universidade", "trajeto", "cimento", "gradiente", "conhecimento", "timidez", "descoberta", "liberdade",
    // ... continue filling with unique, valid words ...
)


