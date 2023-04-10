fun main() {
    var input: String
    var rollCounter = 0
    val rollHandler: RollHandler = RollHandlerImpl()
    val diceChecker: DiceChecker = DiceCheckerImpl()
    var lockedDices = arrayListOf<JambDice>()
    var rollDices: ArrayList<JambDice>
    println("Input Y to play the game:")
    input = readln()
    if (input == "Y" || input == "y") {
        while (rollCounter != 3) {
            println("Input R to roll the dice")

            input = readln()
            if (input == "R" || input == "r") {
                rollCounter++
                rollDices = rollHandler(lockedDices)
                rollDices.forEach { dice ->
                    println("===================")
                    println("${dice.display} ")
                    println("===================")
                }
                println(diceChecker(rollDices).display)
                println("Input index of dices you want to lock (starting from 1). Separate the inputs with ' ' ")
                val diceInput = readln()
                lockedDices = if(diceInput.isNotBlank()) {
                    val newLockedDices = arrayListOf<JambDice>()
                    diceInput
                        .split(" ")
                        .toList()
                        .map(String::toInt)
                        .map(Int::dec)
                        .forEach {diceIndex ->
                        newLockedDices.add(rollDices[diceIndex])
                    }
                    newLockedDices
                } else {
                    arrayListOf()
                }
            }
        }
    }
}