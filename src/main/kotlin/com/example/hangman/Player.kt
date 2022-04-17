package com.example.hangman

data class Player(var lives: Int = 6, var winner: Boolean = false, var turns: Int = 0) {

    fun makeGuess(game: Game, guess: Char) {
        if (guess.lowercaseChar() in game.alreadyGuessed) {
            println("Already guessed $guess")
            return
        }
        game.alreadyGuessed.add(guess.lowercaseChar())
        this.turns++
        if (guess in game.word) {
            for (index in game.word.indices) {
                if (game.word[index] == guess) {
                    game.phrase[index] = guess
                }
            }
            println("You have guessed correctly")
            if (game.phrase.equals(game.word)) {
                this.winner = true
                return
            }
        } else {
            println("Bad Luck")
            this.lives--
        }

        if (this.lives == 0) {
            println("You have lost")
        }

        if (game.word.equals(game.phrase)) {
            println("You have won!")
        }
    }
}