package model

open class Player(
    final override val ctNames: MutableList<String>,
    final override val tNames: MutableList<String>
): Game, Team, Shoot {
    override var armor: Int = 0
    override var health: Int = 100

    override val ctId: String = "(CT)"
    override val tId: String = "(T)"
    override var counterTerrorists: Int = 5
    override var terrorists: Int = 5
    private var shuffledCtNames = ctNames
    private var shuffledTNames = tNames

    override var ctBalance: Int = 800
    override var tBalance: Int = 800


    private fun killScreen(name: MutableList<String>, whoKilledName: MutableList<String>, wasKilled: String,
                           whoKilled: String, weapon: MutableList<String>, suicide: Boolean): MutableList<String> {
        name.shuffled().toMutableList()
        if (suicide) {
            println("$wasKilled${name[0]} had committed suicide")
        }
        else {
            println("$wasKilled${name[0]} was killed by " +
                    "$whoKilled${whoKilledName[(0 until whoKilledName.size).random()]}" +
                    " with ${weapon[0]}")
        }
        name.removeAt(0)
        if (name == shuffledCtNames) {
            counterTerrorists -= 1
            if (!suicide) {
                ctBalance += 500
            }
            else {
                tBalance += 500
            }
        }
        else if (name == shuffledTNames) {
            terrorists -= 1
            if (!suicide) {
                tBalance += 500
            }
            else {
                ctBalance += 500
            }
        }
        resetStats()

        return name
    }

    fun dead(weapon: MutableList<String>, suicideOn: Boolean, armorInput: Int, eco: Boolean) {
        println("\n")

        while ((counterTerrorists > 0) && (terrorists > 0)) {
            val shuffledWeapon: MutableList<String> = if (eco){
                weapon.slice(0..5).shuffled().toMutableList()
            } else {
                weapon.shuffled().toMutableList()
            }
            val head = isShoot(armorInput)
            val choice = (0..2).random()
            var suicide = 0
            if (suicideOn) {
                suicide = (0..30).shuffled().last()
            }

            if ((health <= 0) && (choice == 1)) {
                // CT dead
                killScreen(shuffledCtNames, shuffledTNames, ctId, tId, shuffledWeapon, false)
            }
            else if ((health <= 0) && (choice == 2)) {
                // T dead
                killScreen(shuffledTNames, shuffledCtNames, tId, ctId, shuffledWeapon, false)
            }
            else if (suicide == 2 && (health <= 0) && !head) {
                // CT suicide
                killScreen(shuffledCtNames, shuffledTNames, ctId, tId, shuffledWeapon, true)
            }
            else if (suicide == 4 && (health <= 0) && !head) {
                // T suicide
                killScreen(shuffledTNames, shuffledCtNames, tId, ctId, shuffledWeapon, true)
            }
        }
    }

    private fun resetStats() {
        health = 100
        armor = 0
    }
}