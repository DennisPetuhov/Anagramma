package com.example.myfirstapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class MyMainScreenViewModel : ViewModel() {
    private val _text = MutableStateFlow(" ")
    val text: StateFlow<String> get() = _text
    private val _anagram = MutableStateFlow(" ")
    val anagram: StateFlow<String> get() = _anagram
    fun onValueChange(newText: String) {
        _text.value = newText
    }
init {
    makeAnagramAuto()
}



    fun makeAnagramByButton(newText: String) {
        viewModelScope.launch {
            makeAnagramGreatAgain(newText).collect { _anagram.emit(it) }
        }
    }

    private fun makeAnagramAuto() {
        viewModelScope.launch {
            _text.flatMapLatest {
                makeAnagramGreatAgain(it)
            }.collect {
                _anagram.emit(it)
            }
        }
    }

}