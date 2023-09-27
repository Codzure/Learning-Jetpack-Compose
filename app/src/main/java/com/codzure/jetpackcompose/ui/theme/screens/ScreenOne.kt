package com.codzure.jetpackcompose.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable
fun ScreenOne(
    onBackPressed: () -> Unit
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
        border = null,
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //MyComposableUI()
            //HorizontalUI()
            //ColumnLazy()
            RowLazy()
        }
    }
}

@Composable
private fun MyComposableUI() {
    // vertically
    Column(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Click me",
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.Green
        )


        Button(onClick = {}) {
            Text(text = "Click me again")
        }
    }

}



@Composable
private fun HorizontalUI(){
    // horizontally
    Row(
        modifier = Modifier.fillMaxSize(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello World",
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(4.dp)
        )

        Button(onClick = {}) {
            Text("Button Text")
        }
    }
}

@Composable
private fun ColumnLazy(){
    val items = mutableListOf("Name1","Name2","Name3","Name4","Name5")
    // Vertical
    LazyColumn(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       items(items){ it ->
           Text(text = it)
       }
    }
}

@Composable
private fun RowLazy(){
    val items = mutableListOf("Name1","Name2","Name3","Name4","Name5")
    // Horizontal
    LazyRow(
        modifier = Modifier.fillMaxSize(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        items(items){ it ->
            Text(
                text = it,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

