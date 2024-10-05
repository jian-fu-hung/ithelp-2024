package com.jerryhong.ithelpday20

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.jerryhong.ithelpday20.databinding.ActivityInfoBinding
import com.jerryhong.ithelpday20.ui.theme.ITHelpDay20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay20Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ViewBindingComposable(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val mText = remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(200.dp)
            .padding(16.dp)
    ) {
        AndroidView(
            factory = {
                TextView(it).apply {
                    text = "Hello ${mText.value}"
                    setTextColor(resources.getColor(R.color.purple_200, null))
                }
            },
            update = {
                it.text = "Hello ${mText.value}"
            }
        )
        Button(
            onClick = {
                mText.value = "Android"
            }
        ) {
            Text("Run")
        }
    }
}

@Composable
fun AndroidViewComposable(modifier: Modifier = Modifier) {
    val mText = remember { mutableStateOf("") }
    var tv: TextView? = null
    var btn: Button? = null
    AndroidView(
        factory = {
            LayoutInflater.from(it).inflate(R.layout.activity_info, null).apply {
                tv = findViewById(R.id.tv)
                btn = findViewById(R.id.btn)
                btn?.setOnClickListener {
                    mText.value = "Android"
                }
            }

        },
        update = {
            tv?.text = "Hello ${mText.value}"
        }
    )
}

@Composable
fun ViewBindingComposable(modifier: Modifier = Modifier) {
    AndroidViewBinding(ActivityInfoBinding::inflate) {
        this.btn.setOnClickListener {
            this.tv.text = "Hello Android"
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay20Theme {
        Greeting()
    }
}

@Preview(showBackground = true)
@Composable
fun AndroidViewComposablePreview() {
    ITHelpDay20Theme {
        AndroidViewComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun ViewBindingComposablePreview() {
    ITHelpDay20Theme {
        ViewBindingComposable()
    }
}