package com.kr.ui_categories.ui.categoriesdetailsui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kr.components.ui.theme.InputTextColor
import com.kr.ui_categories.ui.categoriesui.component.color

@ExperimentalMaterial3Api
@Composable
fun CategoryDetailsItems(categoryItems : String) {

    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    val itemssub = listOf(
        "sub of items",
        "sub of items",
        "sub of items",
        "sub of items",
        "sub of items",
        "sub of items",
        "sub of items",
    )


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.None,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f)
                        .padding(start = 15.dp),
                    text = categoryItems,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(InputTextColor)
            ) {

            }



                if (expandedState) {
                   // Spacer(modifier = Modifier.padding(top = 10.dp))
/*

                      Text(
                        text = itemssub.toString(),
                    )
*/



                        LazyColumn(
                            content = {

                                items(itemssub) { categoryIS ->
                                    CategoryDetailsSubItems(categoryIS = categoryIS)

                                }

                            },
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp),
                            userScrollEnabled = false

                            )

                    }

            }
        }
    }
