package com.example.hangman

data class Game(val word: String) {
    var phrase: StringBuilder = StringBuilder("")
    val alreadyGuessed: MutableList<Char> = mutableListOf()

    fun initializePhrase() {
        for (i in word.indices) {
            phrase.append("_")
        }
    }
}