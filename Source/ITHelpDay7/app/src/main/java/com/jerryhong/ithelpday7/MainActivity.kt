package com.jerryhong.ithelpday7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday7.ui.theme.ITHelpDay7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay7Theme {
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
    Image(
        painter = painterResource(R.drawable.fc6_nightly_wind_down),
        contentDescription = ""
    )
}

@Composable
fun ContentFitScaleComposable(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.fc6_nightly_wind_down),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = modifier.width(500.dp).height(500.dp)
    )
}

@Composable
fun ContentScaleCropComposable(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.fc6_nightly_wind_down),
        contentDescription = "",
        contentScale = ContentScale.FillBounds,
        modifier = modifier.width(500.dp).height(500.dp)
    )
}

@Composable
fun AlphaComposable(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.fc6_nightly_wind_down),
        contentDescription = "",
        alpha = 0.5f
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay7Theme {
        Greeting()
    }
}

@Preview(showBackground = true)
@Composable
fun ContentScaleComposablePreview() {
    ITHelpDay7Theme {
        ContentFitScaleComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun ContentScaleCropComposablePreview() {
    ITHelpDay7Theme {
        ContentScaleCropComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun AlphaComposablePreview() {
    ITHelpDay7Theme {
        AlphaComposable()
    }
}