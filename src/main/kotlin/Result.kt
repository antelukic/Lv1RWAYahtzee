enum class Result(val display: String) {
    YAHTZEE("You have yahtzee! Congrats"),
    POKER("You have poker! Congrats"),
    STRAIGHTS("You have straights! Congrats"),
    NOTHING("Unfortunately, you haven't got anything. Better luck next time!")
}