package com.kr.ui_categories.ui.categoriesdetailsui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kr.ui_categories.ui.categoriesdetailsui.component.CategoryDetailsItems


@ExperimentalMaterial3Api
@Composable
fun CategoryDetailsScreen(navController: NavController
) {


    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
     val items = listOf(
         "items of category",
         "items of category",
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
                Spacer(modifier = Modifier.padding(20.dp))

                Card(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(0.9f)
                        .background(color = Color.White)
                        .fillMaxSize(),
                    shape = RoundedCornerShape(28.dp),
                    elevation = 2.dp,
                    backgroundColor = Color.White
                ) {}



                LazyColumn(
                    content = {

                        items(items) { categoryI ->
                            CategoryDetailsItems(categoryItems = categoryI)


                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(top = 20.dp, bottom = 20.dp)
                        .background(Color.White),


                    )

               /* if (state.error.isNotBlank()) {
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
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
*/

            }

        }
    }







