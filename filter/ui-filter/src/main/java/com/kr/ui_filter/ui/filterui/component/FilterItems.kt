@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class)

package com.kr.ui_filter.ui.filterui.component

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.material.*
import androidx.compose.material.Card
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.kr.components.ui.theme.InputTextColor
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.SecondaryColor
import com.kr.ui_filter.R

@ExperimentalMaterialApi
@Composable
fun FilterItems(filterItems : String) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    var selectedInputChip by remember { mutableStateOf(false) }

    val sliderfrom by remember { mutableStateOf(0f) }
    val sliderto by remember { mutableStateOf(50000f) }
    var sliderPosition by remember { mutableStateOf(sliderfrom..sliderto) }
    val interactionSource = MutableInteractionSource()
    val colors = SliderDefaults.colors(thumbColor = PrimaryColor, activeTrackColor = PrimaryColor)
    var heigh :Int = 0
    var filteritemssub : List<FilterState> = listOf()




    val popularbrands = listOf(
        "popular1",
        "popular2",
        "popular3",
        "popular4",
        "popular5",
        "popular6",
        "popular7",
    )


    val categoriesitemssub = listOf(
        "categories of items1",
        "categories of items2",
        "categories of items3",
        "categories of items4",
        "categories of items5",
        "categories of items6",
        "categories of items7",
    )
    val categoriesitems by remember {
        mutableStateOf(
            (categoriesitemssub).map {
                FilterState(
                    title = it,
                    isSelected = false
                )
            }
        )
    }

    val branditemssub = listOf(
        "brand of items1",
        "brand of items2",
        "brand of items3",
        "brand of items4",
        "brand of items5",
        "brand of items6",
        "brand of items7",
    )
    val branditems by remember {
        mutableStateOf(
            (branditemssub).map {
                FilterState(
                    title = it,
                    isSelected = false
                )
            }
        )
    }


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
                val pbrandsize :String

                if (filterItems =="items of Filter brand"){
                    pbrandsize = "( ${popularbrands.size} )"
                }else{
                    pbrandsize=""
                }
                Text(
                    modifier = Modifier
                        .weight(6f)
                        .padding(start = 12.dp),
                    text = "$filterItems $pbrandsize",
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
                    androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = "Drop-Down Arrow")
                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                color = InputTextColor,
                thickness = 1.dp
            )
            when(filterItems){
                "items of Filter categories" ->{
                    heigh= 44 * categoriesitemssub.size
                    filteritemssub =categoriesitems

                }
                "items of Filter brand"->{
                    heigh= 44 * branditemssub.size +330
                    filteritemssub =branditems

                }
                "items of Filter price"->{
                    heigh= 150

                }
            }


            if (expandedState) {
                Spacer(modifier = Modifier.padding(10.dp))

                Box(modifier = Modifier
                    .height(heigh.dp)
                    .fillMaxWidth()
                    .background(Color.White)) {

                    LazyColumn(
                        content = {
                            if (filterItems !== "items of Filter price") {
                                if (filterItems == "items of Filter brand") {
                                    item {
                                        Spacer(modifier = Modifier.padding(8.dp))

                                        Text(
                                            text = "Popular brands",
                                            fontSize = 16.sp,
                                            color = PrimaryColor,
                                        )
                                    }

                                    item {
                                        Spacer(modifier = Modifier.padding(15.dp))
                                        FlowRow(
                                            mainAxisAlignment = MainAxisAlignment.Start,
                                           crossAxisAlignment =FlowCrossAxisAlignment.Start ,
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
                                    item {
                                        Spacer(modifier = Modifier.padding(10.dp))

                                        Text(
                                            text = "Other brands",
                                            fontSize = 16.sp,
                                            color = PrimaryColor,
                                        )
                                        Spacer(modifier = Modifier.padding(10.dp))

                                    }
                                }


                                itemsIndexed(filteritemssub) { index,filterIS ->

                                //    FilterSubItems(filterSubItems = categoriesitemssub , index = index)

                                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
                                        ) {



                                        Checkbox(
                                            checked = filteritemssub[index].isSelected,
                                            onCheckedChange = {
                                                filteritemssub =    filteritemssub.mapIndexed { j, item ->
                                                    if(index == j) {
                                                        item.copy(isSelected = !item.isSelected)
                                                    } else item

                                                }
                                                //   categoriesitems[index].isSelected==it
                                                           //
                                                              //
                                                              // Log.d("ListList","is $categoriesitems")

                                                /*  filterSubItems.isSelected= it
                                                  Toast.makeText(
                                                      context,
                                                      "user checked : ${filterSubItems.isSelected}",
                                                      Toast.LENGTH_SHORT
                                                  ).show()
                                                  Log.d("ListList","is $filterSubItems")
                                  */
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

                                    Log.d("ListList","is $categoriesitems")
                                    Log.d("ListList","is $branditems")

                                    Spacer(modifier = Modifier.padding(7.dp))

                                }

                            }else {
                                item {
                                    Column(modifier = Modifier
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
                                                enabled = true ,


                                                colors = colors
                                            )
                                        Spacer(modifier = Modifier.padding(10.dp))

                                        Row(horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically ,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(40.dp)
                                            ) {
                                            Surface(modifier = Modifier
                                                .weight(1f)
                                                .height(40.dp),
                                                shape = RoundedCornerShape(20.dp),
                                                border = BorderStroke(width = 2.dp, color = com.kr.components.ui.theme.FilterChip),
                                                contentColor = PrimaryColor,

                                                ){
                                                Text(text = "${sliderPosition.start.toInt()} SAR", modifier = Modifier.padding(top = 10.dp, start = 40.dp , end = 25.dp))
                                            }
                                            Spacer(modifier = Modifier.padding(7.dp))

                                            Surface(modifier = Modifier
                                                .weight(1f)
                                                .height(40.dp),
                                                shape = RoundedCornerShape(20.dp),
                                                border = BorderStroke(width = 2.dp, color = com.kr.components.ui.theme.FilterChip),
                                                contentColor = PrimaryColor

                                                ) {
                                                Text(text = "${sliderPosition.endInclusive.toInt()} SAR", modifier = Modifier.padding(top = 10.dp, start = 40.dp , end = 25.dp)
                                                    )
                                            }
                                        }

                                      }

                                    }
                                }

                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        userScrollEnabled = true,
                    )
                }
            }
        }
    }
}




