package com.jerryhong.ithelpday4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jerryhong.ithelpday4.ui.theme.ITHelpDay4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay4Theme {
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
    Column(
        modifier = modifier
            .height(200.dp)
            .width(200.dp)
    ) {
        Text(
            text = "Hello $name!",
            fontSize = 36.sp,
            textAlign = TextAlign.Left,
            modifier = modifier.fillMaxWidth()
        )
        Text(
            text = "Hello $name!",
            textAlign = TextAlign.Center,
            color = Color.Red,
            modifier = modifier.fillMaxWidth(),
        )
        Text(
            text = "Hello $name!",
            textAlign = TextAlign.Right,
            modifier = modifier
                .fillMaxWidth()
                .clickable {

                }
        )
    }

}

@Composable
fun TextOverflowComposable(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = modifier.height(100.dp).width(100.dp)
        ) {
            Text(
                text = "Hello Compose ".repeat(50),
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.fillMaxWidth()
            )
        }
        Box(
            modifier = modifier.height(100.dp).width(100.dp)
        ) {
            Text(
                text = "Hello Compose ".repeat(50),
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Visible,
                color = Color.Red,
                modifier = modifier.fillMaxWidth()
            )
        }
        Box(
            modifier = modifier.height(100.dp).width(100.dp)
        ) {
            Text(
                text = "Hello Compose ".repeat(50),
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Clip,
                color = Color.Blue,
                modifier = modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun BuildAnnotatedStringComposable(modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(Color.Blue)) {
                append("Hello")
            }
            withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                append("Flutter")
            }
            append("Compose")
        }
    )
}

@Composable
fun ClickableTextComposable(modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            append("點擊 ")
            withLink(
                LinkAnnotation.Url(
                    "https://developer.android.com/jetpack/compose",
                    TextLinkStyles(style = SpanStyle(color = Color.Blue))
                )
            ) {
                append("連結")
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay4Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun TextOverflowComposablePreview() {
    ITHelpDay4Theme {
        TextOverflowComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun BuildAnnotatedStringComposablePreview() {
    ITHelpDay4Theme {
        BuildAnnotatedStringComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun ClickableTextComposablePreview() {
    ITHelpDay4Theme {
        ClickableTextComposable()
    }
}
