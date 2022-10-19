package com.kr.ui_categories.ui.categoriesdetailsui

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kr.components.ui.theme.InputTextColor
import com.kr.ui_categories.ui.categoriesdetailsui.component.CategoryDetailsItems
import com.kr.ui_categories.ui.categoriesdetailsui.component.CategoryDetailsSubItems
//import com.kr.categories_domain.model.Categories
import com.kr.ui_categories.ui.categoriesui.component.CategoriesItems


@ExperimentalMaterial3Api
@Composable
fun CategoryDetailsScreen(navController: NavController
) {


    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
     val items = listOf("items of category",
         "items of category",
         "items of category",
         "items of category",
         "items of category",
         "items of category",
         "items of category",
         "items of category",
     )

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), scaffoldState = scaffoldState
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)

        ) {
            Card(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(0.9f)
                    .background(color = InputTextColor)
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(28.dp))
            ) {

            }

            Row() {


            LazyColumn(
                content = {

                    items(items) { categoryI ->
                        CategoryDetailsItems(categoryItems = categoryI)

                    }

                },
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth(0.9f)
                    .padding(top = 20.dp, bottom = 20.dp)
                    .background(Color.White)
                    ,
                verticalArrangement = Arrangement.spacedBy(3.dp)

                )


        }
    }
        }
    }







/*

content = {

    items(items) { categoryI ->
        CategoryDetailsItems(categoryItems = categoryI)

    }

}*/
