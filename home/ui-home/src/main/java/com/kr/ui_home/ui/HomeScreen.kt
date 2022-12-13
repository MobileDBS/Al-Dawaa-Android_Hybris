package com.kr.ui_home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor


@Composable
fun HomeScreen(navController: NavController) {
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
