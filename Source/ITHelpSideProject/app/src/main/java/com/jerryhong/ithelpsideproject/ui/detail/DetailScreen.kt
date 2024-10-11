package com.jerryhong.ithelpsideproject.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jerryhong.ithelpsideproject.AppApplication
import com.jerryhong.ithelpsideproject.core.AppDataManagerMock
import com.jerryhong.ithelpsideproject.data.SubscriptionViewData
import com.jerryhong.ithelpsideproject.ui.theme.ITHelpSideProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    viewModel: DetailViewModel = viewModel(factory = DetailViewModel.createFactory((LocalContext.current.applicationContext as AppApplication).getAppDataManager())),
    productId: String,
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    viewModel.getData(productId)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("產品")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController?.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                actions = {

                }
            )
        }
    ) { innerPadding ->
        when (state) {
            is DetailState.Empty -> {}
            is DetailState.Create -> {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    DetailForm(null, onProductValueChange = {
                        viewModel.saveData(it)
                    })
                }
            }
            is DetailState.Edit -> {
                val data = (state as DetailState.Edit).data
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    DetailForm(data, onProductValueChange = {
                        viewModel.saveData(it)
                    })
                }

            }
            is DetailState.Error -> {}
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailForm(item: SubscriptionViewData? = null, onProductValueChange: (data: SubscriptionViewData) -> Unit) {
    Column {
        val options = listOf("月訂閱", "年訂閱", "一次性購買")
        var selectedOptionText by remember { mutableStateOf(item?.cycle ?: options[0]) }
        var product by remember { mutableStateOf(item?.name ?: "") }
        var price by remember { mutableStateOf(item?.price ?: "") }
        var expanded by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = product,
            onValueChange = {product = it},
            label = {
                Text("訂閱產品")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Face,
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        OutlinedTextField(
            value = price,
            onValueChange = {price = it},
            label = {
                Text("價格")
            },
            prefix = {
                Text("$")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Face,
                    contentDescription = ""
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                value = selectedOptionText,
                readOnly = true,
                onValueChange = {selectedOptionText = it},
                label = {
                    Text("訂閱類型")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Face,
                        contentDescription = ""
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .menuAnchor(),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
            )
            ExposedDropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = {
                            Text(text = selectionOption)
                        },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val newData = SubscriptionViewData(
                        id = item?.id ?: "",
                        name = product,
                        price = price,
                        cycle = selectedOptionText
                    )
                    onProductValueChange.invoke(newData)
                }
            ) {
                Text("儲存")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    ITHelpSideProjectTheme {
        DetailScreen(viewModel = DetailViewModel(AppDataManagerMock()), productId = "1")
    }
}