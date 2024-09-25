package com.jerryhong.ithelpday10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.jerryhong.ithelpday10.ui.theme.ITHelpDay10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay10Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        dialogTitle = "Hello",
                        dialogText = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(dialogTitle: String, dialogText: String, modifier: Modifier = Modifier) {
    AlertDialog(
        icon = {
            Icon(Icons.Filled.CheckCircle, contentDescription = "Example Icon")
        },
        title = {
            Text(
                text = dialogTitle,
                fontSize = 40.sp
            )
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            // 使用者關閉對話方塊時 (例如輕觸對話方塊外部區域) 呼叫
        },
        confirmButton = {
            TextButton(
                onClick = {}
            ) {
                Text("確認")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {}
            ) {
                Text("取消")
            }
        }
    )
}

@Composable
fun CustomDialogComposable(modifier: Modifier = Modifier) {
    Dialog(
        onDismissRequest = {}
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(

                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Title",
                    modifier = modifier.padding(16.dp)
                )
                Text(
                    text = "內容",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxWidth()
                ) {
                    TextButton (
                        onClick = {}
                    ) {
                        Text("確認")
                    }
                    TextButton(
                        onClick = {}
                    ) {
                        Text("確認")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay10Theme {
        Greeting("標題", "內容")
    }
}

@Preview(showBackground = true)
@Composable
fun CustomDialogComposablePreview() {
    ITHelpDay10Theme {
        CustomDialogComposable()
    }
}