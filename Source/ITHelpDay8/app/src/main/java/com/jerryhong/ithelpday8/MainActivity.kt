package com.jerryhong.ithelpday8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday8.ui.theme.ITHelpDay8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay8Theme {
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
    Column() {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

}

@Composable
fun ColumnArrangementComposable(name: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier.background(Color.Blue),
        )
        Text(
            text = "Hello $name!",
            modifier = modifier.background(Color.Red),
        )
    }

}

@Composable
fun RowComposable(name: String, modifier: Modifier = Modifier) {
    Row() {
        Text(
            text = "Hello $name!",
            modifier = modifier.background(Color.Blue),
        )
        Text(
            text = "Hello $name!",
            modifier = modifier.background(Color.Red),
        )
    }
}

@Composable
fun RowArrangementComposable(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End,
        modifier = modifier
            .width(300.dp)
            .height(100.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier.background(Color.Blue),
        )
        Text(
            text = "Hello $name!",
            modifier = modifier.background(Color.Red),
        )
    }
}

@Composable
fun BoxComposable(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(200.dp),
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier.align(Alignment.BottomStart)
        )
        Icon(
            imageVector = Icons.Filled.Call,
            contentDescription = "menu",
            modifier = modifier.align(Alignment.TopEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay8Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ArrangementComposablePreview() {
    ITHelpDay8Theme {
        ColumnArrangementComposable("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun RowComposablePreview() {
    ITHelpDay8Theme {
        RowComposable("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun RowArrangementComposablePreview() {
    ITHelpDay8Theme {
        RowArrangementComposable("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxComposablePreview() {
    ITHelpDay8Theme {
        BoxComposable("Android")
    }
}