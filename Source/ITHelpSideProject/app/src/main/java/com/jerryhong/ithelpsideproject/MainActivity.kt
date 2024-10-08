package com.jerryhong.ithelpsideproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jerryhong.ithelpsideproject.data.SubscriptionViewData
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
        composable(route = "detail/{id}") {
            DetailScreen(navController = navController, modifier = modifier)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier) {
    val list = listOf(
        SubscriptionViewData(name = "Apple TV", price = "$10/month"),
        SubscriptionViewData(name = "Youtube Premium", price = "$10/month"),
        SubscriptionViewData(name = "Apple Music", price = "$10/month"),
        SubscriptionViewData(name = "Netflix", price = "$10/month"),
        SubscriptionViewData(name = "Discord", price = "$10/month")
    )
    LazyColumn (
        modifier = modifier.fillMaxWidth().fillMaxHeight()
    ) {
        items(list) { item: SubscriptionViewData ->
            SubscriptionItem(modifier = modifier, navController = navController, name = item.name, item.price)
        }
    }
}

@Composable
fun DetailScreen(navController: NavController, modifier: Modifier) {

}

@Composable
fun SubscriptionItem(modifier: Modifier, navController: NavController, name: String, price: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = modifier.height(32.dp).width(32.dp)
        )
        Column(
            modifier = modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(
                text = name,
                fontSize = 24.sp
            )
            Text(
                text = price
            )
        }
        IconButton(onClick = {

        }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Localized description"
            )
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ITHelpSideProjectTheme {
        MainScreen()
    }
}