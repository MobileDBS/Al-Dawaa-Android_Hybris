@file:OptIn(ExperimentalMaterial3Api::class)

package com.kr.ui_filter.ui.filterui

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.RangeSlider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.kr.components.ui.theme.InputTextColor
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.SecondaryColor
import com.kr.components.ui.theme.ShapeTabButtons
import com.kr.ui_filter.R
import com.kr.ui_filter.ui.filterui.component.FilterItems
import com.kr.ui_filter.ui.filterui.component.FilterState
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
/*
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
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }*/




        }

    }
}


////////////////////////////////////////////////////////////////
/*


@ExperimentalMaterialApi
@Composable
fun FilterScreen(
    navController: NavController,
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    var selectedInputChip by remember { mutableStateOf(false) }
    val colors = SliderDefaults.colors(thumbColor = PrimaryColor, activeTrackColor = PrimaryColor)
    val sliderfrom by remember { mutableStateOf(0f) }
    val sliderto by remember { mutableStateOf(50000f) }
    var sliderPosition by remember { mutableStateOf(sliderfrom..sliderto) }

    val interactionSource = MutableInteractionSource()
    var heigh: Int = 0
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


    val popularbrands = listOf(
        "popular1",
        "popular2",
        "popular3",
        "popular4",
        "popular5",
        "popular6",
        "popular7",
    )


    var categoriesitems by remember {
        mutableStateOf(
            listOf(
                "categories of items1",
                "categories of items2",
                "categories of items3",
                "categories of items4",
                "categories of items5",
                "categories of items6",
                "categories of items7",
            ).map {
                FilterState(
                    title = it,
                    isSelected = false
                )
            }
        )
    }

    var branditems by remember {
        mutableStateOf(
            listOf(
                "brand of items1",
                "brand of items2",
                "brand of items3",
                "brand of items4",
                "brand of items5",
                "brand of items6",
                "brand of items7",
            ).map {
                FilterState(
                    title = it,
                    isSelected = false
                )
            }
        )
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

                */
/*items(filterRowitems) { filterRI ->
                    SortByItems(sortByItems = filterRI)

                }
*//*

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
                    item {
                        filteritems.forEachIndexed { index, filters ->

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
                                shape = androidx.compose.material3.Shapes.None,
                                onClick = {
                                    expandedState = !expandedState
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                        .background(Color.White)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        val pbrandsize: String

                                        if (filters == "items of Filter brand") {
                                            pbrandsize = "( ${popularbrands.size} )"
                                        } else {
                                            pbrandsize = ""
                                        }
                                        Text(
                                            modifier = Modifier
                                                .weight(6f)
                                                .padding(start = 12.dp),
                                            text = "$filters $pbrandsize",
                                            maxLines = 1,
                                            fontSize = 16.sp,
                                            overflow = TextOverflow.Ellipsis
                                        )

                                        IconButton(
                                            modifier = Modifier
                                                .weight(1f)
                                                .rotate(rotationState),
                                            onClick = {
                                                expandedState = !expandedState
                                            }) {
                                            androidx.compose.material3.Icon(painter = painterResource(
                                                id = R.drawable.ic_arrow_right),
                                                contentDescription = "Drop-Down Arrow")
                                        }
                                    }

                                    Divider(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        color = InputTextColor,
                                        thickness = 1.dp
                                    )
                                }

                                if (expandedState) {

                                    Box(modifier = Modifier
                                        .height(heigh.dp)
                                        .fillMaxWidth()
                                        .background(Color.White)) {

                                        LazyColumn(content = {

                                            when (filters) {
                                                "items of Filter categories" -> {
                                                    heigh = 44 * categoriesitems.size

                                                    itemsIndexed(categoriesitems) { index, filterIS ->


                                                        Row(verticalAlignment = Alignment.CenterVertically,
                                                            modifier = Modifier.height(30.dp)
                                                        ) {


                                                            Checkbox(
                                                                checked = categoriesitems[index].isSelected,
                                                                onCheckedChange = {
                                                                    categoriesitems =
                                                                        categoriesitems.mapIndexed { ind, item ->
                                                                            if (index == ind) {
                                                                                item.copy(isSelected = !item.isSelected)
                                                                            } else item

                                                                        }

                                                                },
                                                                colors = CheckboxDefaults.colors(
                                                                    checkedColor = SecondaryColor,
                                                                    checkmarkColor = PrimaryColor,
                                                                    uncheckedColor = PrimaryColor,
                                                                )
                                                            )
                                                            Text(
                                                                text = categoriesitems[index].title,
                                                                color = PrimaryColor,

                                                                )

                                                        }
                                                        Spacer(modifier = Modifier.padding(7.dp))

                                                    }


                                                }
                                                "items of Filter brand" -> {
                                                    heigh = 44 * branditems.size + 330

                                                    item {
                                                        Spacer(modifier = Modifier.padding(15.dp))
                                                        FlowRow(
                                                            mainAxisAlignment = MainAxisAlignment.Start,
                                                            crossAxisAlignment = FlowCrossAxisAlignment.Start ,
                                                            mainAxisSpacing = 15.dp,
                                                            crossAxisSpacing = 15.dp,
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .fillMaxHeight()
                                                        ) {
                                                            popularbrands.forEach { items ->

                                                                InputChip(

                                                                    onClick = {
                                                                        selectedInputChip = !selectedInputChip
                                                                    },
                                                                    label = { Text(items ,
                                                                        modifier = Modifier.padding(10.dp)
                                                                    ) },

                                                                    trailingIcon = {
                                                                        Icon(
                                                                            imageVector = Icons.Filled.Close,
                                                                            contentDescription = "popular chip close",
                                                                            modifier = Modifier.clickable {  }
                                                                        )

                                                                    },
                                                                    modifier = Modifier.height(40.dp)
                                                                    ,
                                                                    shape = RoundedCornerShape(20.dp),
                                                                    colors = InputChipDefaults.inputChipColors(containerColor = SecondaryColor,
                                                                        labelColor = PrimaryColor,),
                                                                    border = InputChipDefaults.inputChipBorder(Color.Transparent)

                                                                )
                                                            }
                                                        }
                                                    }


                                                    itemsIndexed(branditems) { index, filterIS ->


                                                        Row(verticalAlignment = Alignment.CenterVertically,
                                                            modifier = Modifier.height(30.dp)
                                                        ) {


                                                            Checkbox(
                                                                checked = branditems[index].isSelected,
                                                                onCheckedChange = {
                                                                    branditems =
                                                                        branditems.mapIndexed { ind, item ->
                                                                            if (index == ind) {
                                                                                item.copy(isSelected = !item.isSelected)
                                                                            } else item

                                                                        }

                                                                },
                                                                colors = CheckboxDefaults.colors(
                                                                    checkedColor = SecondaryColor,
                                                                    checkmarkColor = PrimaryColor,
                                                                    uncheckedColor = PrimaryColor,
                                                                )
                                                            )
                                                            Text(
                                                                text = branditems[index].title,
                                                                color = PrimaryColor,

                                                                )

                                                        }
                                                        Spacer(modifier = Modifier.padding(7.dp))

                                                    }

                                                }
                                                "items of Filter price" -> {
                                                    heigh = 150
                                                    item {
                                                        PriceSlider()

                                                    }
                                                }
                                            }

                                        })


                                    }


                                }

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
                        }
                    }


                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight()
                    .padding(top = 20.dp, bottom = 70.dp)
                    .background(Color.White),


                )

            */
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
*//*



        }

    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PriceSlider (){

    val colors = SliderDefaults.colors(thumbColor = PrimaryColor, activeTrackColor = PrimaryColor)
    val sliderfrom by remember { mutableStateOf(0f) }
    val sliderto by remember { mutableStateOf(50000f) }
    var sliderPosition by remember { mutableStateOf(sliderfrom..sliderto) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {


        Text(
            text = "Price range",
            fontSize = 16.sp,
            color = PrimaryColor,
        )



        RangeSlider(
            modifier = Modifier
                .semantics {
                    contentDescription = "Description"
                }
                .fillMaxWidth(),
            values = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..50000f,
            onValueChangeFinished = {

                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            enabled = true,


            colors = colors
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 2.dp,
                    color = com.kr.components.ui.theme.FilterChip),
                contentColor = PrimaryColor,

                ) {
                Text(text = "${sliderPosition.start.toInt()} SAR",
                    modifier = Modifier.padding(top = 10.dp,
                        start = 40.dp,
                        end = 25.dp))
            }
            Spacer(modifier = Modifier.padding(7.dp))

            Surface(modifier = Modifier
                .weight(1f)
                .height(40.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 2.dp,
                    color = com.kr.components.ui.theme.FilterChip),
                contentColor = PrimaryColor

            ) {
                Text(text = "${sliderPosition.endInclusive.toInt()} SAR",
                    modifier = Modifier.padding(top = 10.dp,
                        start = 40.dp,
                        end = 25.dp)
                )
            }
        }

    }

}*/
