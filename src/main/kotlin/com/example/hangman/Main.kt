package com.example.hangman

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

fun main() {
    val game = Game("test")
    val player = Player()

    game.initializePhrase()

    while (player.lives > 0 && !player.winner) {

        if (game.phrase.equals(game.word)) {
            println("good game, you win")
            break
        }
        println("Lives: ${player.lives}")
        println()
        println(game.phrase)
        println("Already guessed: ${game.alreadyGuessed}")
        println()
        print("What is your guess?")

        val guessArray = readln().toCharArray()
        val guess = guessArray[0]

        if (guess in 'a'..'z') {
            player.makeGuess(game, guess)
        }
    }
}