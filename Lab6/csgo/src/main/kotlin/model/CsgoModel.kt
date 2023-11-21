package model

import view.CsgoView

class CsgoModel {
    var ctRounds = 0
    var tRounds = 0
    private var ctStreak = 0
    private var tStreak = 0

    fun ecoState(rounds: CsgoModel, printStatement: CsgoView, entities: Player, weapons: Buy) {
        if (rounds.ctStreak == 3) {
            printStatement.ecoRound(rounds.ctRounds, rounds.tRounds,"ct")
            entities.dead(weapons.ecoRound(), true, 0, true)
        } else if (rounds.tStreak == 3) {
            printStatement.ecoRound(rounds.ctRounds, rounds.tRounds, "t")
            entities.dead(weapons.ecoRound(), true, 0, true)
        } else {
            entities.dead(weapons.read(10), true, 200, false)
        }
    }

    fun winState(rounds: CsgoModel, bomb: Bomb, entities: Player, printStatement: CsgoView) {
        if (bomb.plant(true) || entities.terrorists > entities.counterTerrorists
            && entities.counterTerrorists == 0) {
            printStatement.roundOver("t")
            rounds.tStreak = 0
            rounds.addRounds("t")
        } else if (!bomb.plant(true) || entities.counterTerrorists > entities.terrorists) {
            printStatement.roundOver("ct")
            rounds.ctStreak = 0
            rounds.addRounds("ct")
        }
    }

    fun matchState(rounds: CsgoModel, printStatement: CsgoView): Boolean {
        var result = false
        if (rounds.ctRounds == 16 && rounds.ctRounds > rounds.tRounds) {
            printStatement.matchOver("ct")
            result = true
        } else if (rounds.tRounds == 16 && rounds.tRounds > rounds.ctRounds) {
            printStatement.matchOver("t")
            result = true
        } else if (rounds.ctRounds == 15 && rounds.tRounds == 15) {
            printStatement.matchOver("draw")
            result = true
        }
        return result
    }

    fun simState(printStatement: CsgoView): Boolean {
        printStatement.matchOver("repeat")
        val result: Boolean = when (readln().lowercase()) {
            "y" -> {
                false
            }

            "n" -> {
                true
            }

            else -> true
        }
        return result
    }

    private fun addRounds(team: String) {
        if (team == "ct") {
            ctRounds++
            tStreak++
        }
        else if (team == "t") {
            tRounds++
            ctStreak++
        }
    }

    fun entities(): Player {
        return Player(
            mutableListOf("John", "Chad", "Brian", "Cory", "Finn"),
            mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach")
        )
    }

    fun weapons(): Buy {
        return Buy()
    }

    fun bomb(entities: Player): Bomb {
        return Bomb(entities.ctNames, entities.tNames)
    }
}