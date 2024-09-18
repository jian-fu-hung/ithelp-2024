package com.jerryhong.ithelpday2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.buildSpannedString
import com.jerryhong.ithelpday2.ui.theme.ITHelpDay2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay2Theme {
                Scaffold(modifier = Modifier.fillMaxHeight()) { innerPadding ->
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
    buildSpannedString {  }
    val annotatedString = buildAnnotatedString {
        append("I have read")
        withStyle(style = MaterialTheme.typography.headlineLarge.toSpanStyle()) {
            append(" Terms and Condition")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        ) {
            append("World\n")
        }
    }
    Text(
        text = annotatedString, // 前面不能再額外加字 效果會失效
        modifier = modifier
            .padding(16.dp)
            .height(200.dp),
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay2Theme {
        Greeting("World")
    }
}

//@Preview(showBackground = true, widthDp = 600, heightDp = 100)
@Composable
fun Test2Preview() {
    ITHelpDay2Theme {
        Greeting("World")
    }
}

//@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun Test3Preview() {
    ITHelpDay2Theme {
        Greeting("World")
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Test4Preview() {
    ITHelpDay2Theme {
        Greeting("Jerry")
    }
}