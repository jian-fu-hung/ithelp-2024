package com.jerryhong.ithelpsideproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jerryhong.ithelpsideproject.ui.detail.DetailScreen
import com.jerryhong.ithelpsideproject.ui.home.HomeScreen
import com.jerryhong.ithelpsideproject.ui.theme.ITHelpSideProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ITHelpSideProjectTheme {
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
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController, modifier = modifier)
        }
        composable(
            route = "detail",
        ) {
            DetailScreen(productId = "", navController = navController, modifier = modifier)
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            DetailScreen(productId = it.arguments?.getString("id") ?: "", navController = navController, modifier = modifier)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ITHelpSideProjectTheme {
        MainScreen()
    }
}