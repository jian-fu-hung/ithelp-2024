package com.jerryhong.ithelpday28

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday28.ui.theme.ITHelpDay28Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay28Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val number = remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = "${number.intValue}"
        )
        Button(
            onClick = {
                number.intValue ++
            }
        ) {
            Text(
                text = "Add",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay28Theme {
        Greeting()
    }
}