package com.jerryhong.ithelpday13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerryhong.ithelpday13.ui.theme.ITHelpDay13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay13Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumnComposable(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LazyColumnComposable(modifier: Modifier = Modifier) {
    LazyColumn {
        items(20) {
            Card(
                modifier = modifier.padding(20.dp)
            ) {
                Column(
                    modifier = modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Item $it",
                        modifier = modifier,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "content",
                        modifier = modifier.width(200.dp).height(200.dp)
                    )
                    Row {
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Filled.Create,
                                contentDescription = ""
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun LazyRowComposable(modifier: Modifier = Modifier) {
    LazyRow {
        items(20) {
            Card(
                modifier = modifier.padding(20.dp)
            ) {
                Column(
                    modifier = modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Item $it",
                        modifier = modifier,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "content",
                        modifier = modifier.width(200.dp).height(200.dp)
                    )
                    Row {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.Create,
                                contentDescription = ""
                            )
                        }
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnComposablePreview() {
    ITHelpDay13Theme {
        LazyColumnComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun LazyRowComposablePreview() {
    ITHelpDay13Theme {
        LazyRowComposable()
    }
}