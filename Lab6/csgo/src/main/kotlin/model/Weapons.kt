package model

abstract class Weapons: Game {
    abstract var weapons: MutableList<String>

    var ctPistol = mapOf("USP-S" to 1, "Dual Berettas" to 2, "P250" to 3, "Five-SeveN" to 4, "Desert Eagle" to 5)

    var ctHeavy = mapOf("Nova" to 1, "XM1014" to 2, "MAG-7" to 3, "M249" to 4, "Negev" to 5)

    var ctSmg = mapOf("MP9" to 1, "MP7" to 2, "UMP" to 3, "P90" to 4, "PP-Bizon" to 5)

    var ctRifle = mapOf("FAMAS" to 1, "M4A1-S" to 2, "SSG 08" to 3, "AUG" to 4, "AWP" to 5, "SCAR-20" to 6)

    var ctGrenade = mapOf("Incendiary Grenade" to 1, "Decoy Grenade" to 2, "Flashbang" to 3, "High Explosive Grenade" to 4,
        "Smoke Grenade" to 5)

    var ctEquipment = mapOf("Kevlar Vest" to 1, "Kevlar + Helmet" to 2, "Zeus x27" to 3, "Defuse Kit" to 4)

    var ammo = mapOf("12/24" to 1, "30/110" to 2, "13/26" to 3, "20/100" to 4, "7/35" to 5,
        "8/32" to 6, "7/32" to 7, "5/32" to 8, "100/200" to 9, "150/300" to 10, "30/130" to 11, "30/120" to 12,
        "25/100" to 13, "50/100" to 14, "64/120" to 15, "25/90" to 16, "20/80" to 17, "10/90" to 18, "30/90" to 19,
        "10/30" to 20, "20/90" to 21)
}