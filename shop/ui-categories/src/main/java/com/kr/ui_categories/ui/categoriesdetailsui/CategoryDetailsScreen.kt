
package com.kr.ui_categories.ui.categoriesdetailsui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MenuDefaults.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kr.ui_categories.R
import com.kr.ui_categories.ui.categoriesdetailsui.component.CategoryDetailsItems
import  com.kr.components.ui.theme.InputHint
import com.kr.components.ui.theme.ShapeBigButtons

@ExperimentalMaterial3Api
@Composable
fun CategoryDetailsScreen(navController: NavController
) {

    var expandedState by remember { mutableStateOf(false) }

    val context = LocalContext.current
//    val scaffoldState = rememberScaffoldState()
     val items = listOf(
         "items of category1",
         "items of category2",
         "items of category3",
         "items of category4",
         "items of category5",
         "items of category6",
         "items of category7",
         "items of category8",
         "items of category9",
         )

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
//        scaffoldState = scaffoldState
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
                    elevation =CardDefaults.cardElevation(2.dp),//change
                    colors = CardDefaults.cardColors(
                    //    containerColor =  MaterialTheme.colorScheme.surfaceVariant,
                    ),
                ) {}



                LazyColumn(
                    content = {

                        items(items) { categoryI ->
                            CategoryDetailsItems(categoryItems = categoryI)


                        }
                        item {
                            Row(modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically) {
                                Divider(color = InputHint, thickness = 1.dp, modifier = Modifier.weight(5f))
                                Text(text = "Or",modifier = Modifier.weight(1f))
                                Divider(color = InputHint, thickness = 1.dp,modifier = Modifier.weight(5f))

                            }
                        }

                        item {

                            OutlinedButton(
                                onClick = {
                                    expandedState = !expandedState

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                                    .background(Color.White)
                                    .animateContentSize(
                                        animationSpec = tween(
                                            durationMillis = 500,
                                            easing = LinearOutSlowInEasing
                                        )
                                    ),
                                shape = ShapeBigButtons.small,
                              //  elevation = 4.dp

                            ) {
                                Row(modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(id = R.drawable.ic_giftcard),
                                        contentDescription = "Drop-Down Arrow",
                                        modifier = Modifier
                                            .weight(1f)
                                    , tint = Color.Unspecified)
                                    Text(text = "Buy gift card",
                                        modifier = Modifier
                                            .weight(6f))

                                    Icon(painter = painterResource(id = R.drawable.ic_arrow_right),
                                        contentDescription = "Drop-Down Arrow",
                                        modifier = Modifier
                                            .weight(1f))
                                    
                                }
                               
                                if (expandedState){



                                }

                            }

                        }

                    }, state = rememberLazyListState(),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(top = 20.dp, bottom = 50.dp)
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







