interface DiceChecker {

    operator fun invoke(input: ArrayList<JambDice>): Result
}

class DiceCheckerImpl : DiceChecker {

    override fun invoke(input: ArrayList<JambDice>): Result {
        if (checkForYamb(input)) return Result.YAHTZEE
        if (checkForPoker(input)) return Result.POKER
        if (checkForStraights(input)) return Result.STRAIGHTS
        return Result.NOTHING
    }

    private fun checkForYamb(input: ArrayList<JambDice>): Boolean {
        if (input.count { it == JambDice.One } >= 5) return true
        if (input.count { it == JambDice.Two } >= 5) return true
        if (input.count { it == JambDice.Three } >= 5) return true
        if (input.count { it == JambDice.Four } >= 5) return true
        if (input.count { it == JambDice.Five } >= 5) return true
        return input.count { it == JambDice.Six } >= 5
    }

    private fun checkForPoker(input: ArrayList<JambDice>): Boolean {
        if (input.count { it == JambDice.One } == 4) return true
        if (input.count { it == JambDice.Two } == 4) return true
        if (input.count { it == JambDice.Three } == 4) return true
        if (input.count { it == JambDice.Four } == 4) return true
        if (input.count { it == JambDice.Five } == 4) return true
        return input.count { it == JambDice.Six } == 4
    }

    private fun checkForStraights(input: ArrayList<JambDice>): Boolean {
        return input.containsAll(
            arrayListOf(
                JambDice.One,
                JambDice.Two,
                JambDice.Three,
                JambDice.Four,
                JambDice.Five
            )
        ) || input.containsAll(
            arrayListOf(
                JambDice.Two,
                JambDice.Three,
                JambDice.Four,
                JambDice.Five,
                JambDice.Six
            )
        )
       /* var numOfSingles = 0
        if (input.count { it == JambDice.One } == 1) numOfSingles++
        if (input.count { it == JambDice.Two } == 1) numOfSingles++
        if (input.count { it == JambDice.Tree } == 1) numOfSingles++
        if (input.count { it == JambDice.Four } == 1) numOfSingles++
        if (input.count { it == JambDice.Five } == 1) numOfSingles++
        if (input.count { it == JambDice.Six } == 1) numOfSingles++
        return numOfSingles >= 5*/
    }
}
