package com.example.myfirstapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MyMainScreen(myViewModel: MyMainScreenViewModel = viewModel()) {
    val enteredText: String = myViewModel.incomingText.collectAsState().value
    val filterText: String = myViewModel.filter.collectAsState().value
    val anagram: String = myViewModel.anagram.collectAsState().value
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Text(text = anagram, modifier = Modifier.weight(1f))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize().semantics { testTag = "text1" },
                value = enteredText,
                onValueChange = { myViewModel.onValueChangedTextInput(it) },
                minLines = 2,
                label = { Text("Enter Text For Anagram") },
                placeholder = { Text("Text For Anagram And More Text") }
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            OutlinedTextField(modifier = Modifier
                .weight(1f)
                .wrapContentHeight(),
                value = filterText,
                onValueChange = { myViewModel.onValueChangedFilterInput(it) },
                minLines = 2,
                label = { Text("Enter Text Fort Filter") },
                placeholder = { Text("Symbols To Ignore and more Symbols") })
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .weight(1f))
        }
    }
}