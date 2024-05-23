package com.example.myfirstapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MyMainScreenKtTest {




        @get:Rule
        val composeTestRule = createComposeRule()
        lateinit var mockViewModel: MyMainScreenViewModel

//            @Before
//            fun setUp() {
//                mockViewModel = MyMainScreenViewModel()
//            }
//
//            @After
//            fun tearDown() {
//            }
//
//            @Test
//            fun myMainScreen() {
//                composeTestRule.setContent {
//                    MyMainScreen(mockViewModel)
//                }
//                composeTestRule.onNodeWithText("Hello").assertIsDisplayed()
//            }

        @Before
        fun setUp() {
            mockViewModel = MyMainScreenViewModel()
        }

        @After
        fun tearDown() {
        }

        @Test
        fun myMainScreen() {
        }


        @Test
        fun myMainScreen_displaysCorrectText1() {
            mockViewModel.onValueChangedTextInput( "test text")

            composeTestRule.setContent {
                MyMainScreen(mockViewModel)
            }
            composeTestRule.onNodeWithText("test text").assertIsDisplayed()
            composeTestRule.onNodeWithText("Test Filter").assertIsDisplayed()
        }
    @Test
    fun myMainScreen_displaysCorrectText2() {
        mockViewModel.onValueChangedFilterInput("Test Filter")

        composeTestRule.setContent {
            MyMainScreen(mockViewModel)
        }
        composeTestRule.onNodeWithText("Test Filter").assertIsDisplayed()
    }
    @Test
    fun myMainScreen_displaysCorrectText() {
        mockViewModel.onValueChangedTextInput( "test text")
        mockViewModel.onValueChangedFilterInput("Test Filter")
//            mockViewModel.makeAnagramAuto()

        composeTestRule.setContent {
            MyMainScreen(mockViewModel)
        }

        composeTestRule.onNodeWithText("test text").assertIsDisplayed()
//            composeTestRule.onNodeWithTag("text1").assertTextEquals("tset txet").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test Filter").assertIsDisplayed()
//            composeTestRule.onNodeWithText("Test Anagram").assertIsDisplayed()
    }

}