package com.kr.ui_offers.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor


@Composable
fun OffersScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column() {

            Text(text = "Home Screen", color= PrimaryColor)

            OutlinedButton(onClick = { navController.navigate("Product_List") }) {
                Text("Open ProductList")
            }
        }
    }

}


