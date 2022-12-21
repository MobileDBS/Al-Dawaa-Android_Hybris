package com.kr.productlist

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kr.components.CustomModalBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    navController: NavController,
   // showBottomSheet: (Boolean) -> Unit
) {
    var showMutable by remember { mutableStateOf(false) }


    Column() {

        OutlinedButton(onClick = {
            navController.navigate("Filter_Screen")
        }) {
            Text("Open filter")
        }

        OutlinedButton(onClick = { navController.navigate("Map") }) {
            Text("Open Map")

        }
        DisplayProductList()
    }


    if (showMutable) {
        val systemUiController = rememberSystemUiController()
        CustomModalBottomSheet(navController = navController)
    }

}



