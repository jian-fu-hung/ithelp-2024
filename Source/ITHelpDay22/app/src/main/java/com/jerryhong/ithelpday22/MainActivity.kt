package com.jerryhong.ithelpday22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.jerryhong.ithelpday22.ui.theme.ITHelpDay22Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpDay22Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController, modifier = modifier) }
        composable(
            route = "home/{text}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                }
            )
        ) {
            HomeScreen(navController, it.arguments?.getString("text"), modifier)
        }
        composable(
            route = "login/{name}",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "URI/{name}"
                }
            )
        ) {
            HomeScreen(navController, it.arguments?.getString("name"), modifier)
        }

    }
}

@Composable
fun HomeScreen(navController: NavController, name: String?, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(200.dp)
            .padding(16.dp)
    ) {
        Text("Hello ${name ?: ""}")
    }
}

@Composable
fun LoginScreen(navController: NavController, name: String? = "", modifier: Modifier) {
    val text = remember { mutableStateOf(name ?: "") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(200.dp)
            .padding(16.dp)
    ) {
        Text("Login Screen")
        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = modifier.padding(16.dp)
        )
        Button(onClick = { navController.navigate("home/${text.value}") }) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpDay22Theme {
        MainScreen()
    }
}