package com.kr.ui_categories.ui.categoriesui

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
//import com.kr.categories_domain.model.Categories
import com.kr.ui_categories.ui.categoriesui.component.CategoriesItems


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CategoriesScreen(navController: NavController, viewModel: CategoriesViewModel= hiltViewModel()
) {

    val state = viewModel.state.value

    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()


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
            Box( modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {


                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {

                    items(state.Categorieslist) { categor ->
                        CategoriesItems(result = categor, onItemClick = {
                            navController.navigate("Category_Items")

                        })

                    }

                }, userScrollEnabled = true,
                    modifier = Modifier
                        .padding(bottom = 70.dp)
                        .fillMaxHeight(0.9f)
                        .fillMaxWidth(0.9f),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                    // contentPadding = PaddingValues(10.dp)
                )


                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = PrimaryColor)
                }


            }

        }
    }
}




