package com.jerryhong.ithelpday5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday5.ui.theme.ITHelpDay5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay5Theme {
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
    var text by remember { mutableStateOf("123456") }
    TextField(
        value = text,
        onValueChange = {text = it},
        label = { Text("Label") },
        prefix = { Text ("+886") },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = modifier.width(64.dp).height(64.dp)
            )
        },
        placeholder = {Text("Enter Phone")},
        modifier = modifier.padding(10.dp)
    )
}

@Composable
fun KeyboardOptionsComposable(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("1234") }
    TextField(
        value = text,
        onValueChange = { text = it},
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        modifier = modifier.padding(10.dp)
    )
}

@Composable
fun OnValueChangeComposable(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it.uppercase()},
        modifier = modifier.padding(10.dp)
    )
}

@Composable
fun OnValueChange2Composable(modifier: Modifier = Modifier) {
    val pattern = remember { Regex("^[A-Za-z0-9_.]+\$") }
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            if (it.isEmpty() || it.matches(pattern)) {
                text = it
            }
        },
        modifier = modifier.padding(10.dp)
    )
}

@Composable
fun OutlinedTextFieldComposable(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("Hello") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it},
        label = { Text("Label") },
        placeholder = {Text("Enter Email")},
        modifier = modifier.padding(10.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay5Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun KeyboardOptionsComposablePreview() {
    ITHelpDay5Theme {
        KeyboardOptionsComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun OnValueChangeComposablePreview() {
    ITHelpDay5Theme {
        OnValueChangeComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun OnValueChange2ComposablePreview() {
    ITHelpDay5Theme {
        OnValueChange2Composable()
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextFieldComposablePreview() {
    ITHelpDay5Theme {
        OutlinedTextFieldComposable()
    }
}

