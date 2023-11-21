package model

interface Shoot: Game {
    fun shot(armorInput: Int) {
        armor = armorInput
        val lowDamage = listOf(10, 25, 50, 75)
        val highDamage = listOf(10, 25, 50, 75, 100)
        println("Shot!")

        if (health > 0) {
            when (armor) {
                200 -> {
                    health -= lowDamage.random()
                    armor -= lowDamage.random()
                }
                100 -> {
                    health -= highDamage.random()
                    armor -= highDamage.random()
                }
                else -> {
                    health -= highDamage.random()
                }
            }
        }
    }

    // Function to take the shoot
    fun isShoot(armorInput: Int): Boolean {
        var result = false
        val isShot = (0..1).random()
        val headshot = (0..9).random()

        if (isShot == 1) {
            if (headshot == 1 && armor <= 100) {
                println("HeadShot!")
                health -= 100
                armor -= 100
                result = true
            } else if (headshot == 1 && armor == 200) {
                println("HeadShot! Helmet broke!")
                health -= 50
                armor -= 100
                result = true
            } else {
                shot(armorInput)
                result = false
            }
        }
        return result
    }
}