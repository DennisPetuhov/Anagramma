package com.example.myfirstapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MyMainScreen(myViewModel: MyMainScreenViewModel = viewModel()) {
    var enteredText = myViewModel.text.collectAsState().value
    val anagram = myViewModel.anagram.collectAsState().value
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
                    .weight(2f)
            )
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(),
                value = enteredText,
                onValueChange = { myViewModel.onValueChange(it) },
                minLines = 2,
//                label = { Text("Enter Text For Anagram") },
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
                value = enteredText,
                onValueChange = { enteredText = it },
                minLines = 2,
                label = { Text("Enter Text Fort Filter") },
                placeholder = { Text("Symbols To Ignore and more Symbols") })
            Button(
                modifier = Modifier.wrapContentSize(),
//                onClick = { myViewModel.makeAnagram(enteredText) },
                onClick = { myViewModel.makeAnagramByButton(enteredText) },
            ) {
                Text(text = "Press To Make Anagram")
            }
//            Spacer(
//                Modifier
//                    .fillMaxWidth()
//                    .weight(6f)
//            )
        }
    }
}