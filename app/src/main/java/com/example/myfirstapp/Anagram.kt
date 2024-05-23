package com.example.myfirstapp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

const val PATTERN = " "

fun makeAnagramGreatAgain(
    incomingText: String,
    lettersToFilter: String
): Flow<String> {
    val resultText = StringBuilder()
    val myText = Regex(PATTERN).split(incomingText)
    for (word in myText) {
        val reversedWord =
            if (lettersToFilter.isEmpty()) symbolReverseWord(word)
            else filteredReversedWord(word, lettersToFilter)
        resultText.append(reversedWord)
        if (reversedWord != myText.last()) resultText.append(" ")
    }
    println("$resultText\n****")
    return flow { emit(resultText.toString()) }
}

fun symbolReverseWord(word: String): String {
    val reversedWord = StringBuilder()
    var k = 0
    var reversedWordWithoutDigits = ""
    reversedWordWithoutDigits = word.filter { it.isLetter() }.reversed()
    for (i in word.indices) {
        if (word[i].isLetter()) {
            reversedWord.append(reversedWordWithoutDigits[k])
            k++
        } else {
            reversedWord.append(word[i])
        }
    }
    return reversedWord.toString()
}

fun filteredReversedWord(word: String, letters: String): String {
    val reversedWord = StringBuilder()
    var k = 0
    var wordWithoutFilteredLetters = ""
    var reversedBuffer = ""
    wordWithoutFilteredLetters = word.filter { it !in letters }
    reversedBuffer = wordWithoutFilteredLetters.reversed()
    for (i in word.indices) {
        if (word[i] !in letters) {
            reversedWord.append(reversedBuffer[k])
            k++
        } else {
            reversedWord.append(word[i])
        }
    }
    return reversedWord.toString()
}