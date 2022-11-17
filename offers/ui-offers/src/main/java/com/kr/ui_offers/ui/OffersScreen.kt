package com.kr.ui_offers.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun OffersScreen(navController: NavController) {
    OutlinedButton(onClick = { navController.navigate("Product_List") }) {
        Text("I'm an Outlined Button")
    }
 /*   Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Offers Screen")
    }*/
}


