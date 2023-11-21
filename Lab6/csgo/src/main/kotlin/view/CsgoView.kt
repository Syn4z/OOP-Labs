package view

class CsgoView {
    fun matchStart(matchCount: Int) {
        return println("Match nr: $matchCount")
    }

    fun roundStart(roundNr: Int) {
        println("New Round started, round nr: $roundNr\n")
    }

    fun ecoRound(ctRounds: Int, tRounds: Int, eco: String) {
        if (eco == "ct") {
            println("CounterTerrorists lost 3 round in a row: $ctRounds VS $tRounds \nThey have an Economic round")
        } else if (eco == "t") {
            println("Terrorists lost 3 round in a row: $tRounds VS $ctRounds \nThey have an Economic round")
        }
    }

    fun roundOver(win: String){
        if (win == "ct") {
            println(
                "\n\tROUND IS OVER\n" +
                        "\tCounterTerrorists Win!"
            )
        } else if (win == "t") {
            println("\n\tROUND IS OVER\n" +
                    "\tTerrorists Win!")
        }
    }

    fun roundStats(ctPlayer: Int, tPlayer: Int, ctRounds: Int, tRounds: Int){
        println("\nRemaining CounterTerrorists: $ctPlayer")
        println("Remaining Terrorists: $tPlayer")
        println("\n\t CT won: $ctRounds rounds; T won: $tRounds rounds\n")
    }

    fun matchOver(match: String) {
        when (match) {
            "ct" -> {
                println("\nCounterTerrorists won the match")
            }
            "t" -> {
                println("\nTerrorists won the match")
            }
            "draw" -> {
                println("\nDraw")
            }
            "repeat" -> {
                println("Next match?(y/n)")
            }
        }
    }
}