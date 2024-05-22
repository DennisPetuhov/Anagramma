package com.example.myfirstapp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun makeAnagramGreatAgain(text: String = "a1bcd efg!h"): Flow<String> {
    val resultText = StringBuilder()
    val pattern = " "
    val myText = Regex(pattern).split(text)
    for (word in myText) {
        val reversedWord = reverseWord(word)
        resultText.append(reversedWord)
        if (reversedWord != myText.last())
            resultText.append(" ")
    }
    println(resultText.toString())
    return flow { emit(resultText.toString()) }
}

fun reverseWord(word: String): String {
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