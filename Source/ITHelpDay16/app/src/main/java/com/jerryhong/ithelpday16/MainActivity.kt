package com.jerryhong.ithelpday16

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday16.ui.theme.ITHelpDay16Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay16Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var visible by remember {
        mutableStateOf(false)
    }
    Column {
        Button(
            onClick = {
                visible = visible.not()
            }
        ) {
            Text(
                text = "Say Hello!",
                modifier = modifier
            )
        }
        AnimatedVisibility(visible) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
    }
}

@Composable
fun animateAsStateComposable() {
    var isClicked by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(if (isClicked) Color.Red else Color.Blue)
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color)
            .clickable { isClicked = !isClicked }
    )
}

@Composable
fun animateContentComposable() {
    Column {
        var count by remember { mutableIntStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Add")
        }
        AnimatedContent(targetState = count, label = "") { targetCount ->
            Text(text = "Count: $targetCount")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay16Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun animateAsStateComposablePreview() {
    ITHelpDay16Theme {
        animateAsStateComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun animateContentPreview() {
    ITHelpDay16Theme {
        animateContentComposable()
    }
}