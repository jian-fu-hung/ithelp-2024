package com.jerryhong.ithelpday9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.jerryhong.ithelpday9.ui.theme.ITHelpDay9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay9Theme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
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
    ConstraintLayout(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {

        val (text1, text2, text3) = createRefs()
        Text(
            text = "Hello $name!",
            modifier = modifier.constrainAs(text1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        )
        Text(
            text = "Hi $name!",
            modifier = modifier.constrainAs(text2) {
                top.linkTo(text1.bottom, margin = 16.dp)
            }
        )
        Text(
            text = "Hey $name!",
            modifier = modifier.constrainAs(text3) {
                top.linkTo(text2.bottom, margin = 16.dp)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun ConstraintSetComposable(name: String, modifier: Modifier = Modifier) {
    val constraints = ConstraintSet{
        val text1 = createRefFor("text1")
        val text2 = createRefFor("text2")
        val text3 = createRefFor("text3")

        constrain(text1) {
            top.linkTo(parent.top, margin = 16.dp)
        }
        constrain(text2) {
            top.linkTo(text1.bottom, margin = 16.dp)
        }
        constrain(text3) {
            top.linkTo(text2.bottom, margin = 16.dp)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(
        constraintSet = constraints,
        modifier = modifier.width(200.dp).height(200.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier.layoutId("text1")
        )
        Text(
            text = "Hi $name!",
            modifier = modifier.layoutId("text2")
        )
        Text(
            text = "Hey $name!",
            modifier = modifier.layoutId("text3")
        )
    }
}

@Composable
fun GuidelineComposable(name: String, modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier.width(200.dp).height(200.dp)
    ) {

        val (text1, text2, text3) = createRefs()
        val startGuideline = createGuidelineFromStart(0.1f)
        val topGuideline = createGuidelineFromTop(0.5f)
        val endGuideline = createGuidelineFromEnd(0.1f)
        Text(
            text = "Hello $name!",
            modifier = modifier.constrainAs(text1) {
                start.linkTo(startGuideline)
            }
        )
        Text(
            text = "Hi $name!",
            modifier = modifier.constrainAs(text2) {
                top.linkTo(topGuideline)
            }
                .background(Color.Blue)
        )
        Text(
            text = "Hey $name!",
            modifier = modifier.constrainAs(text3) {
                end.linkTo(endGuideline)
                bottom.linkTo(topGuideline)
            }
                .background(Color.Red)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ITHelpDay9Theme {
//        Greeting("Android")
//    }
//}

@Preview(showBackground = true)
@Composable
fun ConstraintSetComposablePreview() {
    ITHelpDay9Theme {
        ConstraintSetComposable("Android")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GuidelineComposablePreview() {
//    ITHelpDay9Theme {
//        GuidelineComposable("Android")
//    }
//}