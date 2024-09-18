package com.jerryhong.ithelpday3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday3.ui.theme.ITHelpDay3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay3Theme {
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
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .size(width = 200.dp, height = 300.dp)
                .padding(10.dp)
                .background(color = Color.Red)
                .alpha(0.2f)
                .wrapContentHeight()
        )
    }
}

@Composable
fun SizeComposable(modifier: Modifier = Modifier) {
    Text(
        text = "Hello",
        modifier = modifier.size(width = 200.dp, height = 200.dp)
    )
}

@Composable
fun PaddingComposable(modifier: Modifier = Modifier) {
    Text(
        text = "Hello",
        modifier = modifier.padding(top = 20.dp)
    )
}

@Composable
fun BackgroundComposable(modifier: Modifier = Modifier) {
    Text(
        text = "Hello",
        modifier = modifier.background(Color.Cyan)
    )
}

@Composable
fun FillMaxComposable(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(200.dp),
    ) {
        Text(
            text = "Hello",
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Red)
        )
    }
}

@Composable
fun WeightComposable(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
    ){
        Text(
            text = "Hello",
            modifier = modifier
                .weight(1f)
                .background(Color.Red)
        )
        Text(
            text = "World",
            modifier = modifier
                .weight(1f)
                .background(Color.Blue)
        )
    }
}



@Composable
fun ThenComposable(modifier: Modifier = Modifier) {
    val isBlue = true
    Column (
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
    ){
        Text(
            text = "Hello",
            modifier = modifier
                .then(
                    if(isBlue) {
                        Modifier.background(Color.Blue)
                    } else {
                        Modifier.background(Color.Red)
                    }
                )
                .padding(10.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay3Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun SizeComposablePreview() {
    ITHelpDay3Theme {
        SizeComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun PaddingComposablePreview() {
    ITHelpDay3Theme {
        PaddingComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun BackgroundComposablePreview() {
    ITHelpDay3Theme {
        BackgroundComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun FillMaxComposablePreview() {
    ITHelpDay3Theme {
        FillMaxComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun WeightComposablePreview() {
    ITHelpDay3Theme {
        WeightComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun ThenComposablePreview() {
    ITHelpDay3Theme {
        ThenComposable()
    }
}

