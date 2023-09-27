package com.codzure.jetpackcompose.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.codzure.jetpackcompose.R

@Composable
fun ComposeCard(
    onBackPressed: () -> Unit
) {

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
            TestButton()
        }
    }
}

@Composable
fun TestButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.add_task),
            contentDescription = "Add task button icon",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "Click me to see me change!",
            modifier = Modifier.padding(4.dp))
    }
}
