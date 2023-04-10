import java.security.SecureRandom

interface RollHandler {

    operator fun invoke(lockedDices: ArrayList<JambDice>): ArrayList<JambDice>
}

class RollHandlerImpl : RollHandler {

    override fun invoke(lockedDices: ArrayList<JambDice>): ArrayList<JambDice> {
        val newDices = arrayListOf<JambDice>()

        lockedDices.forEach { lockedDice ->
            newDices.add(lockedDice)
        }

        val secureRandom = SecureRandom()

        while (newDices.count() < 6) {
            JambDice.fromValue(secureRandom.nextInt(7))?.let{ newDices.add(it) }
        }

        return newDices
    }
}