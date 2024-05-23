package com.example.myfirstapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import org.junit.Rule
import org.junit.Test


class MyTestCompose {
    @get:Rule
    val composeRule = createComposeRule()
    @Test
    fun print_semantics_tree(){
        composeRule.setContent {
            MyMainScreen()
        }
        composeRule.onRoot(useUnmergedTree = true).printToLog("MyMainScreen")
    }
}