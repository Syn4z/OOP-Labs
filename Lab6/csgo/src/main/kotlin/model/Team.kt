package model

interface Team {
    val ctNames: MutableList<String> // mutableListOf("John", "Chad", "Brian", "Cory", "Finn")
    val tNames: MutableList<String> // mutableListOf("Arnold", "Kyle", "Ringo", "Rip", "Zach")
    val ctId: String // "(CT)"
    val tId: String // "(T)"
}