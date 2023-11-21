package model

class Bomb(ctNames: MutableList<String>, tNames: MutableList<String>) : Player(ctNames, tNames) {
    // Function to plant the bomb
    fun plant(isPlant: Boolean): Boolean {
        var result = false
        if (isPlant) {
            val planted = (0..3).random()
            if (planted == 1) {
                println("\nBomb has been planted!")
                tBalance += 100
                val explode = (0..5).random()
                if (explode == 0 || counterTerrorists == 0) {
                    println("\nBomb exploded!")
                    tBalance += 500
                    result = true
                } else if (counterTerrorists > 0) {
                    println("\nCounterTerrorists defused the bomb")
                    ctBalance += 500
                    result = false
                }
            }
        }
        return result
    }
}