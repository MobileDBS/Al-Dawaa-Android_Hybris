package com.kr.productlist

import android.content.Intent
import android.location.Location
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.kr.components.CustomMap



    lateinit var currentLocation:Location
    @Composable
    fun ProductListScreen(navController: NavController){
        Column {
       //     context.startActivity(Intent(context,Activity::class.java))
               CustomMap()
            /*     OutlinedButton(onClick = {navController.navigate("Filter_Screen") }) {
                     androidx.compose.material.Text("Open filter")
                 }

                 Scaffold(
                     modifier = Modifier
                         .fillMaxWidth()
                         .fillMaxHeight(), scaffoldState = rememberScaffoldState()
                 ){  Box(
                     modifier = Modifier
                         .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                         .fillMaxHeight()
                         .fillMaxWidth()



                 ) {

                     LazyVerticalGrid(
                         state =   rememberLazyGridState(),
                         columns = GridCells.Fixed(2),
                         userScrollEnabled = true,
                         verticalArrangement = Arrangement.spacedBy(8.dp),
                         horizontalArrangement = Arrangement.spacedBy(8.dp),
                         modifier = Modifier
                             .scrollable(rememberLazyGridState(), orientation = Orientation.Vertical)
                             .fillMaxHeight()
                             .fillMaxWidth()
                         ,
                         content = { items(7) { it-> ProductListItem() }
                         }
                     )
                 }}*/

        }



    }





