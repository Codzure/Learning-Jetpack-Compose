package com.codzure.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.codzure.jetpackcompose.ui.theme.JetpackComposeLearningTheme
import com.codzure.jetpackcompose.ui.theme.screens.ComposeCard
import com.codzure.jetpackcompose.ui.theme.screens.ScreenOne

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme

                ComposeCard( // Replace with the intended start screen.
                    onBackPressed ={
                        finish()
                    }
                )
            }
        }
    }
}