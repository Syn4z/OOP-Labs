
private class Player {
    protected var health = 100

    protected var armor = 0

    val crosshair = mapOf("default" to 1, "cross" to 2, "square" to 3, "circle" to 4, "dot" to 5)

    var timer = 115

    init {
        println("Health = $health")
        println("Armor = $armor")
    }
}

private class View {
    protected var camera = listOf("Start")

    fun lookUp() {
        camera = camera + "Up"
    }

    fun lookDown() {
        camera = camera + "Down"
    }

    fun lookRight() {
        camera = camera + "Right"
    }

    fun lookLeft() {
        camera = camera + "Left"
    }

    init {
        lookDown()
        lookUp()
        lookUp()
        println(camera)
    }
}

private class Move {
    protected var location = ""

    // code in each function for changing position of player
    fun moveFront() {
        location = "Front"
    }

    fun moveBack() {
        location = "Back"
    }

    fun moveRight() {
        location = "Right"
    }

    fun moveLeft() {
        location = "Left"
    }

    init {
        moveBack()
        moveFront()
        moveRight()
        println(location)
    }
}

private class Special {
    var location = ""
    // code to change the vertical position of player
    fun jump() {
        location = "Jump"
    }

    fun crouch() {
        location = "Crouch"
    }

    fun sneak() {
        location = "Sneak"
    }

    init {
        crouch()
        sneak()
        jump()
        println(location)
    }
}

private class Shoot {
    var health = 100

    var armor = 0

    fun shot() {
        println("You've been shot!")
        // different conditions for each of weapons
        health -= 50
        armor -= 30
    }

    init {
        shot()
    }
}

private class Weapons {
    var ctPistol = mapOf("USP-S" to 1, "Dual Berettas" to 2, "P250" to 3, "Five-SeveN" to 4, "Desert Eagle" to 5)

    var ctHeavy = mapOf("Nova" to 1, "XM1014" to 2, "MAG-7" to 3, "M249" to 4, "Negev" to 5)

    var ctSmg = mapOf("MP9" to 1, "MP7" to 2, "UMP" to 3, "P90" to 4, "PP-Bizon" to 5)

    var ctRifle = mapOf("FAMAS" to 1, "M4A1-S" to 2, "SSG 08" to 3, "AUG" to 4, "AWP" to 5, "SCAR-20" to 6)

    var ctGrenade = mapOf("Incendiary Grenade" to 1, "Decoy Grenade" to 2, "Flashbang" to 3, "High Explosive Grenade" to 4,
                            "Smoke Grenade" to 5)

    var ctEquipment = mapOf("Kevlar Vest" to 1, "Kevlar + Helmet" to 2, "Zeus x27" to 3, "Defuse Kit" to 4)

    fun stats() {
        // need to get the stats for the specific gun in the directory
        // damage and armor penetration
        // fire-rate and others
    }

    init {
        println("Pistols are: $ctPistol")
    }
}

private class Bomb {
    var bomb = true
    var isPlant = false

    // function to drop the bomb
    fun drop() {
        bomb = false
    }

    // function to plant the bomb
    fun plant() {
        isPlant = true
    }

    init {
        drop()
        println(bomb)
    }
}

private class Radar {
    var map = ""
    // function to display the map
    fun display() {
        map = "1"
    }

    // adjust the map where the player goes
    fun adjust() {
        map = "2"
    }

    init {
        display()
        println(map)
    }
}

private class Buy {
    // Buy menu
    fun read() {
        var categoryChoise = ""
        println("What type of weapon do you want to buy? ")
        val categoryInput = readLine()!!
        when (categoryInput.toInt()) {
            1 -> categoryChoise = "pistol"
            2 -> categoryChoise = "heavy"
            3 -> categoryChoise = "smg"
            4 -> categoryChoise = "rifle"
            5 -> categoryChoise = "grenade"
            6 -> categoryChoise = "equipment"
            else -> "Not in categories!"
        }
        println("What model do you want to buy? ")
        val typeInput = readLine()!!
        when (typeInput.toInt()) {
            // the specific model of a category
            1 -> println("You bought a: $categoryChoise")
            2 -> println("You bought a: $categoryChoise")
            3 -> println("You bought a: $categoryChoise")
            4 -> println("You bought a: $categoryChoise")
            5 -> println("You bought a: $categoryChoise")
            6 -> println("You bought a: $categoryChoise")
            else -> "Not in the models!"
        }
    }

    init {
        read()
    }
}

private class Money {
    var balance = 800

    // operations to extract or add money
    fun win() {
        balance += 200
    }

    fun lose() {
        balance += 50
    }

    init {
        win()
        lose()
        println("Your balance is: $balance")
    }
}

private class Kill {
    var source = ""

    fun isKill() {
        // variable for source of killing
        source = "Pistol"
    }

    fun suicide() {
        source = "Yourself"
    }

    fun bomb() {
        source = "Terrorist Bomb"
    }

    fun friendly() {
        source = "Your smart teammate"
    }

    init {
        friendly()
        println("You have been killed by: $source")
    }
}

private class PlayerTab {
    var counterTerrorists = 5
    var terrorists = 5

    // changes the nr of ct and t when kill
    fun change() {
        counterTerrorists -= 1
        terrorists -= 2
    }

    fun reload() {
        // resets the nr of ct and t after each round
        counterTerrorists = 5
        terrorists = 5
    }

    init {
        change()
        println("Terrorists: $terrorists")
    }
}

fun main() {
    val obj = Player()

    val obj1 = View()

    val obj2 = Move()

    val obj3 = Special()

    val obj4 = Shoot()

    val obj5 = Buy()

    val obj6 = Money()

    val obj7 = Kill()

    val obj8 = Weapons()

    val obj9 = Bomb()

    val obj10 = Radar()

    val obj11 = PlayerTab()

}
