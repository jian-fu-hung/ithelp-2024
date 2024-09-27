package com.jerryhong.ithelpday12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.jerryhong.ithelpday12.ui.theme.ITHelpDay12Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay12Theme {
                Greeting(
                    name = "Android",
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarAndBottomBarComposable(name: String, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "標題",
                        overflow = TextOverflow.Ellipsis
                    )
                } ,
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Localized description"
                    )
                }
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Localized description"
                    )
                }
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "Localized description"
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Composable
fun SnackBarComposable(name: String, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column {
            Text(
                text = "Hello $name!",
                modifier = modifier.padding(innerPadding)
            )
            Button(
                onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar("Hello $name")
                    }
                }
            ) {
                Text(
                    text = "Show SnackBar"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay12Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarAndBottomBarComposablePreview() {
    ITHelpDay12Theme {
        TopBarAndBottomBarComposable("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun SnackBarComposablePreview() {
    ITHelpDay12Theme {
        SnackBarComposable("Android")
    }
}