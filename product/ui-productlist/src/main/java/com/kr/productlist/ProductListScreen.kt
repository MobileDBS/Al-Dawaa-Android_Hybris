package com.kr.productlist

import android.os.Handler
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kr.components.CustomModalBottomSheet

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductListScreen(
    navController: NavController,
    showBottomSheet: (Boolean) -> Unit
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
        Scaffold(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), scaffoldState = rememberScaffoldState()
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()


            ) {

                LazyVerticalGrid(
                    state = rememberLazyGridState(),
                    columns = GridCells.Fixed(2),
                    userScrollEnabled = true,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .scrollable(rememberLazyGridState(), orientation = Orientation.Vertical)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    content = {
                        items(7) {
                            //Added
                                it ->
                            ProductListItem { showBottomSheet ->
                                showBottomSheet(true)
                                showMutable =(true)
                            }
                        }
                    }
                )
            }
        }

    }


    if (showMutable) {
        val systemUiController = rememberSystemUiController()
        CustomModalBottomSheet(navController = navController)
    }

}



