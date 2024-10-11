package com.jerryhong.ithelpsideproject.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jerryhong.ithelpsideproject.AppApplication
import com.jerryhong.ithelpsideproject.R
import com.jerryhong.ithelpsideproject.core.AppDataManagerMock
import com.jerryhong.ithelpsideproject.data.SubscriptionViewData
import com.jerryhong.ithelpsideproject.ui.theme.ITHelpSideProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel( factory = HomeViewModel.createFactory((LocalContext.current.applicationContext as AppApplication).getAppDataManager())),
    navController: NavController? = null,
    modifier: Modifier = Modifier) {

    val homeState by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("ITHelp Side Project")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController?.navigate("detail")
            }) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        }
    ) { innerPadding ->
        when(homeState)  {
            is HomeState.Empty -> {}
            is HomeState.Error -> {
                val message = (homeState as HomeState.Error).message
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .fillMaxHeight()

                ) {
                    errorScreen(
                        message = message,
                        onClock = {
                            viewModel.reload()
                        }
                    )
                }
            }
            is HomeState.Finish -> {
                val list = (homeState as HomeState.Finish).list
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    items(list) { item: SubscriptionViewData ->
                        SubscriptionItem(
                            modifier = modifier,
                            navController = navController,
                            data = item
                        )
                    }
                }
            }
            is HomeState.Loading -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .fillMaxHeight()

                ) {
                    ProgressBarComposable()
                }
            }
        }

    }
}

@Composable
fun ProgressBarComposable() {
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}

@Composable
fun errorScreen(message: String, onClock: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = message
        )
        Button(
            onClick = onClock
        ) {
            Text(
                text = "重新取得"
            )
        }
    }
}

@Composable
fun SubscriptionItem(
    modifier: Modifier,
    navController: NavController?,
    data: SubscriptionViewData
) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = data.name,
                    fontSize = 24.sp
                )
                Text(
                    text = "$ ${data.price}/${data.cycle}"
                )
            }
            IconButton(onClick = {
                navController?.navigate("detail/${data.id}")
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = ""
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ITHelpSideProjectTheme {
        HomeScreen(viewModel = viewModel(factory = HomeViewModel.createFactory(AppDataManagerMock())))
    }
}
