package com.jerryhong.ithelpday15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday15.ui.theme.ITHelpDay15Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay15Theme {
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
    Canvas(
        modifier = modifier.width(200.dp).height(200.dp).padding(10.dp)
    ) {
        // Draw Triangle
        val path = Path().apply {
            moveTo(size.width/2, 0f)
            lineTo(0f, size.width)
            lineTo(size.height, size.width)
            close()
        }
        drawPath(
            path = path,
            color = Color.Black,
            style = Stroke(
                width = 10F
            )
        )

        // Draw Circle
        drawCircle(
            color = Color.Black,
            center = Offset(size.width/2, size.width*2/3),
            radius = size.width/3.3F,
            style = Stroke(
                width = 10F
            )
        )

        // Draw Line
        drawLine(
            color = Color.Black,
            start = Offset(size.width/2, 0f),
            end = Offset(size.width/2, size.height),
            strokeWidth = 10F
        )
    }
}

@Composable
fun DrawLineComposable(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(0F, size.height/2),
            end = Offset(size.width,size.height/2),
            strokeWidth = 10F
        )

        drawLine(
            color = Color.Black,
            start = Offset(size.width/3, size.height/3),
            end = Offset(size.width/2, size.height - 10),
            strokeWidth = 10F
        )
    }
}

@Composable
fun DrawCircleComposable(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {
        drawCircle(
            color = Color.Black,
            radius = size.width/3
        )

        drawCircle(
            color = Color.Red,
            radius = size.width/4,
            center = Offset(size.width/3, size.height/3),
            style = Stroke(
                width = 10F
            )
        )
    }
}

@Composable
fun drawRectComposable(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {
        drawRect(
            color = Color.Black,
            size = size/2F,
        )
        drawRect(
            color = Color.Gray,
            topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
            size = size / 3F
        )

    }
}

@Composable
fun DrawArcComposable(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {
        drawArc(
            color = Color.Red,
            startAngle = -90f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.width * .25f)
        )
        drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.width * .25f)
        )

        drawArc(
            color = Color.Blue,
            startAngle = 90f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.width * .25f)
        )

        drawArc(
            color = Color.Yellow,
            startAngle = 180f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.width * .25f)
        )
    }
}

@Composable
fun DrawPathComposable(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {
        val path = Path().apply {
            moveTo(0f, size.height/2)
            lineTo(size.width/5, size.width)
            moveTo(size.width/5, size.height/2)
            lineTo(size.height, size.width)
            lineTo(size.width/2, 0f)
            close()
        }
        drawPath(
            path = path,
            color = Color.Black,
            style = Stroke(
                width = 10F
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay15Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun DrawLineComposablePreview() {
    ITHelpDay15Theme {
        DrawLineComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun DrawCircleComposablePreview() {
    ITHelpDay15Theme {
        DrawCircleComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun drawRectComposablePreview() {
    ITHelpDay15Theme {
        drawRectComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun DrawArcComposablePreview() {
    ITHelpDay15Theme {
        DrawArcComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun DrawPathComposablePreview() {
    ITHelpDay15Theme {
        DrawPathComposable()
    }
}

