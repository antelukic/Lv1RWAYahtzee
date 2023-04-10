
sealed class JambDice(val value: Int, val display: String) {

    object One: JambDice(
        value =  1,
        display = """
            
               *
            
        """.trimIndent()
    )

    object Two: JambDice(
        value =  2,
        display = """
                    *
               
            *
        """.trimIndent()
    )

    object Three: JambDice(
        value =  3,
        display = """
                    *
                * 
            *
        """.trimIndent()
    )

    object Four: JambDice(
        value =  4,
        display = """
            *       *
                
            *       *
        """.trimIndent()
    )

    object Five: JambDice(
        value =  5,
        display = """
            *       *
                *
            *       *
        """.trimIndent()
    )

    object Six: JambDice(
        value =  6,
        display = """
            *       *
            *       *    
            *       *
        """.trimIndent()
    )

    companion object {
        fun fromValue(value: Int): JambDice? = when(value) {
            1 -> One
            2 -> Two
            3 -> Three
            4 -> Four
            5 -> Five
            6 -> Six
            else -> null
        }
    }
}

fun List<String>.toJambDices(): ArrayList<JambDice> {
    val dices = arrayListOf<JambDice>()

    map(String::toInt).map(JambDice::fromValue).forEach { jambDice ->
        jambDice?.let { dices.add(it) }
    }

    return dices
}
