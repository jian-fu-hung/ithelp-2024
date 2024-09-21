package com.jerryhong.ithelpday6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday6.ui.theme.ITHelpDay6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay6Theme {
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
    Button(
        modifier = modifier,
        onClick = {}
    ) {
        Text(name)
    }
}

@Composable
fun ColorComposable(name: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        onClick = {}
    ) {
        Text(name)
    }
}

@Composable
fun CustomColorComposable(name: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        colors = ButtonColors(
            containerColor = Color.Green,
            contentColor = Color.Gray,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.LightGray
        ),
        onClick = {}
    ) {
        Text(name)
    }
}

@Composable
fun BorderComposable(name: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        border = BorderStroke(10.dp, Color.Red),
        onClick = {}
    ) {
        Text(name)
    }
}

@Composable
fun ShapeComposable(name: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
        onClick = {}
    ) {
        Text(name)
    }
}

@Composable
fun ElevationComposable(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.width(200.dp).height(100.dp)
    ) {
        Button(
            modifier = modifier,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 15.dp
            ),
            onClick = {}
        ) {
            Text(name)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ITHelpDay6Theme {
//        Greeting("Android")
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun ColorComposablePreview() {
//    ITHelpDay6Theme {
//        ColorComposable("Android")
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CustomColorComposablePreview() {
//    ITHelpDay6Theme {
//        CustomColorComposable("Android")
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun BorderComposablePreview() {
//    ITHelpDay6Theme {
//        BorderComposable("Android")
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ShapeComposablePreview() {
//    ITHelpDay6Theme {
//        ShapeComposable("Android")
//    }
//}
//
@Preview(showBackground = true)
@Composable
fun ElevationComposablePreview() {
    ITHelpDay6Theme {
        ElevationComposable("Android")
    }
}