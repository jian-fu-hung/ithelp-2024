package com.jerryhong.ithelpday17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday17.ui.theme.ITHelpDay17Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay17Theme {
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
    val colorMap = listOf(
        Pair("Red", Color.Red),
        Pair("Blue", Color.Blue),
        Pair("Yellow", Color.Yellow),
        Pair("Green", Color.Green),
        Pair("Cyan", Color.Cyan),
        Pair("LightGray", Color.LightGray),
    )
    val rotation = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val colorName = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Roulette(rotation.value, colorMap)
            Pointer()
        }
        Text(
            text = "${colorName.value}"
        )
        Button(
            modifier = modifier.align(Alignment.CenterHorizontally),
            onClick = {
                // 計算每個區塊的角度範圍
                val anglePerSection = 360 / colorMap.size
                // 隨機選擇區塊編號 (0 到 colorMap.size - 1)
                val randomSection = (0 until 6).random()
                // 指針可接受範圍
                val targetAngle = (270 - anglePerSection .. 271).random()
                // 減360是為了解決大於270的值避免逆時針旋轉
                val finalAngle = if (randomSection * anglePerSection > 271) {
                    targetAngle - (randomSection * anglePerSection - 360)
                } else {
                    targetAngle - (randomSection * anglePerSection)
                }
                scope.launch{
                    // Reset
                    rotation.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = 100,
                            easing = LinearEasing
                        )
                    )

                    rotation.animateTo(
                        targetValue = 360 * 10 + finalAngle.toFloat(),
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = FastOutSlowInEasing
                        )
                    )
                    colorName.value = colorMap[randomSection].first
                }

            }
        ) {
            Text(
                text = "旋轉"
            )}
    }
}


@Composable
fun Pointer(modifier: Modifier = Modifier) {

    Canvas(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {
        val path = Path().apply {
            moveTo(size.width * .5f, size.width * .3f)
            lineTo(size.width * .5f - 20f , size.width * .5f)
            lineTo(size.width * .5f + 20f, size.width * .5f)
            close()
        }
        drawPath(
            path = path,
            color = Color.Black,
        )
        drawArc(
            color = Color.Black,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(40f, 40f),
            topLeft = Offset(size.width * .5f - 20f, size.width * .5f - 20f)
        )
    }
}

@Composable
fun Roulette(currentRotation: Float, colorList: List<Pair<String, Color>>, modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
            .graphicsLayer {
                rotationZ = currentRotation
            }
    ) {
        var mStartAngle = 0f
        val mSweepAngle = 360f / colorList.size
        colorList.forEach { color ->
            drawArc(
                color = color.second,
                startAngle = mStartAngle,
                sweepAngle = mSweepAngle,
                useCenter = true,
                size = Size(size.width * .50f, size.height * .50f),
                topLeft = Offset(size.width * .25f, size.width * .25f)
            )
            mStartAngle += mSweepAngle
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay17Theme {
        Greeting()
    }
}