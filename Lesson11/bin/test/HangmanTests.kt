import kotlin.test.*

class HangmanTests {
    @Test
    fun `getUnfilledWord should return a valid string for a valid length`() {
        val str = getUnfilledWord(3)
        assertEquals("___", str)
    }

    @Test
    fun `getUnfilledWord should return an empty string for 0 length`() {
        val str = getUnfilledWord(0)
        assertEquals("", str)
    }



    @Test
    fun `revealChar should reveal an non revealed char`() {
        // Arrange
        val wordToGuess = "Programacao"
        val currentWord = "___________"

        // Act
        val newCurrentWord = revealChar('a', currentWord, wordToGuess)

        // Assert
        assertEquals("_____a_a_a_", newCurrentWord)
    }

    @Test
    fun `revealChar should return the same currentWord for non existing char in wordToGuess`() {
        // Arrange
        val wordToGuess = "Programacao"
        val currentWord = "___________"

        // Act
        val newCurrentWord = revealChar('z', currentWord, wordToGuess)

        // Assert
        assertEquals(currentWord, newCurrentWord)
    }

    @Test
    fun `revealChar should return the same currentWord for an already revealed char`() {
        // Arrange
        val wordToGuess = "Programacao"
        val currentWord = "_____a_a_a_"

        // Act
        val newCurrentWord = revealChar('a', currentWord, wordToGuess)

        // Assert
        assertEquals(currentWord, newCurrentWord)
    }

    @Test
    fun `revealChar should return the same wordToGuess when the last hidden char is passed`() {
        // Arrange
        val wordToGuess = "Programacao"
        val currentWord = "Pr_gramaca_"

        // Act
        val newCurrentWord = revealChar('o', currentWord, wordToGuess)

        // Assert
        assertEquals(wordToGuess, newCurrentWord)
    }
//    @Test
//    fun pgTest() {
//        val secret = "PG"
//        val initWord = listOf('_','G')
//        val expected = listOf('P','G')
//        assertEquals(expected, update(secret,secret,initWord,'P'))
//    }
}