package com.example.myfirstapp

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MyMainScreenViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var myTestViewModel: MyMainScreenViewModel


    @Before
    fun setup() {
        myTestViewModel = MyMainScreenViewModel()
    }

    @After
    fun cleanup() {
    }

    @Test
    fun settingMainDispatcher() = runTest {
        myTestViewModel.onValueChangedTextInput("Hello World") // Uses testDispatcher, runs its coroutine eagerly
        assertEquals("Hello World", myTestViewModel.incomingText.value)


    }

    @Test
    fun `onValueChange updates text state`() = runBlockingTest {

        myTestViewModel.onValueChangedTextInput("Hello World")
        assertEquals("Hello World", myTestViewModel.incomingText.value)
    }

    @Test
    fun `onValueChange with empty string updates text state`() {
        myTestViewModel.onValueChangedTextInput("")
        assertEquals("", myTestViewModel.incomingText.value)
    }

    @Test
    fun `makeAnagramByButton with empty string updates anagram state`() = runTest {
        myTestViewModel.makeAnagramByButton("")
        assertEquals("", myTestViewModel.anagram.value)
    }
}
