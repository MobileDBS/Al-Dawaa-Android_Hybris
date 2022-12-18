package com.kr.ui_home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor


@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        // contentAlignment = Alignment.Center
    )
    {
        Column(Modifier.padding(8.dp)) {

            Text(text = "Home Screen", color = PrimaryColor)

            OutlinedButton(onClick = { navController.navigate("Product_List") }) {
                Text("Open ProductList")
            }

            HomeProductList(navController)


        }
    }
}


