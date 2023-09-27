package com.codzure.jetpackcompose.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StateManagement(
    onBackPressed: () -> Unit
) {

    val currentValue = remember { mutableStateOf(0) } //Int
    val userName = remember { mutableStateOf("") } //String

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inversePrimary,
        border = null,
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RememberSaveAbleSample()
        }
    }
}

@Composable
fun NoState() {
    var clickCount = 0
    Column {
        Button(onClick = {
            clickCount++
            Log.d("TAG", "NoState: "+clickCount)
        }) {
            Text(text = ""+clickCount+" times clicked")
        }
    }
}

@Composable
fun MutableStateClick() {
    var clickCount by remember {
        mutableStateOf(0)
    }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}

@Composable
fun RememberSample() {
    var clickCount by remember { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}

/**
* Use rememberSaveable to restore your UI state after an activity or process is recreated.
* rememberSaveable retains state across recompositions.
* In addition, rememberSaveable also retains state across activity and process recreation.*/
@Composable
fun RememberSaveAbleSample() {
    var clickCount = rememberSaveable { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount.value++ }) {
            Text(text = "" + clickCount.value + " times clicked")
        }
    }
}