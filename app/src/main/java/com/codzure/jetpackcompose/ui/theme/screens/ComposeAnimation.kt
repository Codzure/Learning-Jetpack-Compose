package com.codzure.jetpackcompose.ui.theme.screens

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codzure.jetpackcompose.R

@Composable
fun ComposeAnimation(
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
            //JetpackAnimation()
            AnimateDpAsState()
        }
    }
}

@Composable
fun JetpackAnimation() {
    var isAnimated by remember {
        mutableStateOf(false)
    }

    val color = remember {
        Animatable(Color.DarkGray)
    }

    // Animate to green based on the "Button click"

    LaunchedEffect(isAnimated){
        color.animateTo(if (isAnimated) Color.Green else Color.Red,
            animationSpec = tween(2000)
        )
    }

    Box(modifier = Modifier
        .fillMaxWidth(0.8f)
        .fillMaxHeight(0.8f)
        .background(color.value)
    )
    
    Button(onClick = { isAnimated = !isAnimated },
        modifier = Modifier.padding(top = 10.dp)) {
        Text(text = "Animate Color")
    }
}

@Composable
fun CircleImage(imageSize: Dp) {
    Image(
        painter = painterResource(R.drawable.add_task),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(imageSize)
            .clip(CircleShape)
            .border(5.dp, Color.Gray, CircleShape)
    )
}

@Composable
private fun AnimateDpAsState() {
    val isNeedExpansion = rememberSaveable{ mutableStateOf(false) }

    val animatedSizeDp: Dp by animateDpAsState(targetValue = if (isNeedExpansion.value) 350.dp else 100.dp)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircleImage(animatedSizeDp)
        Button(
            onClick = {
                isNeedExpansion.value = !isNeedExpansion.value
            },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp)
        ) {
            Text(text = "animateDpAsState")
        }
    }
}


/**modifier = Modifier.background(if(isValidInput) Color.Black else Color.Gray)
However, this approach may not be the most efficient way to handle conditional modifiers, especially when the condition is based on a dynamic property that frequently changes.
In Compose, recomposition can occur frequently, and recomposing the entire Composable tree due to a small change like toggling a background color can lead to performance issues.

While this one-liner might seem concise, it can become less readable as you add more conditions or complex logic.
To address this, consider using the Modifier.then() function to chain modifiers together.*/
// TODO Best practice
/**modifier = Modifier.then(
if (isValidInput) {
    Modifier.background(Color.Black)
} else {
    Modifier.background(Color.Gray)
}
)*/

/**
@Composable
fun MyComposable(countries:List<Country>) {
    LazyColumn{
        items(countries.size, key = {it.id}){
            //content
        }
    }
}*/

/**
While remember {} is great for one-time calculations, it might not be the best choice
when you have a stream of values changing frequently. In such cases, you can use derivedStateOf {}.
Here is an example of how to use derivedStateOf {}:
val state by viewModel.state.collectAsState()

val sorted by remember(state.listData) {
    derivedStateOf { state.listData.sorted() }
}

In this example, state.listData can change frequently.
Instead of recalculating sorted with every change, derivedStateOf {} ensures that sorting only happens when state.listData changes.*/
