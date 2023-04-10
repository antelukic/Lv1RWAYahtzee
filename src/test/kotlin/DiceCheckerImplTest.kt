import org.junit.jupiter.api.Test

class DiceCheckerImplTest {

    private val diceChecker: DiceChecker = DiceCheckerImpl()

    @Test
    fun `assert yahtzee when 5 dices are the same`() {
        val result= diceChecker(arrayListOf(
            JambDice.One,
            JambDice.One,
            JambDice.One,
            JambDice.One,
            JambDice.One,
        ))
        assert(result == Result.YAHTZEE)
    }

    @Test
    fun `assert yahtzee when 6 dices are the same`() {
        val result = diceChecker(arrayListOf(
            JambDice.One,
            JambDice.One,
            JambDice.One,
            JambDice.One,
            JambDice.One,
            JambDice.One,
        ))
        assert(result ==  Result.YAHTZEE)
    }

    @Test
    fun `assert straight when dices are 1,2,3,4,5`() {
        val result = diceChecker(arrayListOf(
            JambDice.One,
            JambDice.Two,
            JambDice.Three,
            JambDice.Four,
            JambDice.Five,
        ))
        assert(result ==  Result.STRAIGHTS)
    }

    @Test
    fun `assert straight when dices are 2,3,4,5,6`() {
        val result = diceChecker(arrayListOf(
            JambDice.Two,
            JambDice.Three,
            JambDice.Four,
            JambDice.Five,
            JambDice.Six,
        ))
        assert(result ==  Result.STRAIGHTS)
    }

    @Test
    fun `assert poker when 4 dices are the same`() {
        val result = diceChecker(arrayListOf(
            JambDice.Two,
            JambDice.Two,
            JambDice.Two,
            JambDice.Two,
        ))
        assert(result ==  Result.POKER)
    }

    @Test
    fun `assert nothing when its nothing`() {
        val result = diceChecker(arrayListOf(
            JambDice.Two,
            JambDice.Three,
            JambDice.Four,
            JambDice.Five,
        ))
        assert(result ==  Result.NOTHING)
    }
}