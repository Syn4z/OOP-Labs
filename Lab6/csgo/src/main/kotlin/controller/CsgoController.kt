package controller

import model.CsgoModel
import view.CsgoView

class CsgoController {
    fun simulation() {
        var matchCount = 1

        while (true) {
            val printStatement = CsgoView()
            val rounds = CsgoModel()

            printStatement.matchStart(matchCount)
            var j = 1

            while (j < 31) {
                printStatement.roundStart(j)

                val entities = CsgoModel().entities()
                val weapons = CsgoModel().weapons()
                val bomb = CsgoModel().bomb(entities)
                val model = CsgoModel()

                // Eco statement
                model.ecoState(rounds, printStatement, entities, weapons)

                // Win situation
                model.winState(rounds, bomb, entities, printStatement)

                // Round stats
                printStatement.roundStats(entities.counterTerrorists, entities.terrorists,
                    rounds.ctRounds, rounds.tRounds)

                // Match outcome possibilities
                if (model.matchState(rounds, printStatement)) {
                    matchCount += 1
                    break
                }

                j++
            }
            // Continue simulation
            if (rounds.simState(printStatement)) {
                break
            }
        }
    }
}