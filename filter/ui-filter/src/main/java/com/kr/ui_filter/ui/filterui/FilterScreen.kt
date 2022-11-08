@file:OptIn(ExperimentalMaterial3Api::class)

package com.kr.ui_filter.ui.filterui

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.ShapeTabButtons
import com.kr.ui_filter.ui.filterui.component.FilterItems
import com.kr.ui_filter.ui.filterui.component.SortByItems


@ExperimentalMaterialApi
@Composable
fun FilterScreen(
    navController: NavController,
) {
    var chipState by remember { mutableStateOf("") }


    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val filteritems = listOf(
        "items of Filter categories",
        "items of Filter brand",
        "items of Filter price",

        )

    val filterRowitems by remember {
        mutableStateOf(listOf(
            "Sort filter 1",
            "Sort filter 2",
            "Sort filter 3",
            "Sort filter 4",
            "Sort filter 5",
            "Sort filter 6",
            "Sort filter 7",
        ))
    }


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
            Spacer(modifier = Modifier.padding(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp)) {
                Text(text = "Sort By")

            }
            Spacer(modifier = Modifier.padding(5.dp))

            LazyRow(content = {
                item {
                    filterRowitems.forEach {
                        SortByItems(context = context,
                            label = it,
                            selected = it == chipState) { chip ->
                            chipState = chip

                        }
                        Spacer(modifier = Modifier.padding(7.dp))

                    }
                }

                /*items(filterRowitems) { filterRI ->
                    SortByItems(sortByItems = filterRI)

                }
*/
            },
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp)
            ) {
                Text(text = "Filter your search results")
            }

            LazyColumn(
                content = {

                    itemsIndexed(filteritems) { index, filterI ->

                        FilterItems(filterItems = filterI)


                    }

                    item {
                        Spacer(modifier = Modifier.padding(10.dp))
                        OutlinedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(53.dp)
                                .clip(shape = ShapeTabButtons.small),
                            colors = ButtonDefaults.outlinedButtonColors(Color.Transparent),
                            shape = ShapeTabButtons.small,
                            border = BorderStroke(2.dp, PrimaryColor),

                            onClick = {
                                //  navController.navigate("MainUi")


                            },


                            ) {
                            Text(
                                text = "Apply",
                                fontSize = 20.sp,
                                color = PrimaryColor,
                            )


                        }
                    }



                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight()
                    .padding(top = 20.dp, bottom = 70.dp)
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




