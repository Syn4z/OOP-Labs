package model

interface Game {
    var health: Int
    var armor: Int

    var counterTerrorists: Int
    var terrorists: Int

    var ctBalance: Int
    var tBalance: Int
}