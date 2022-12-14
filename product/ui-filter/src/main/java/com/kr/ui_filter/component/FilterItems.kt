package com.kr.ui_filter.component

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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.kr.product_datasource.dto.Filter
import com.kr.ui_filter.ui.filterui.component.FilterState
import com.kr.ui_filter.ui.filterui.component.FilterSubItemsBrand
import com.kr.ui_filter.ui.filterui.component.FilterSubItemsCategories
import com.kr.ui_filter.R

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
@Composable
fun FilterItems(filterItems: String) {
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
    val filter = Filter.Filteritems()
    // val popularbrands = filter.filtersubpop

    /* val popularbrands = listOf(
         "popular1",
         "popular2",
         "popular3",
         "popular4",
         "popular5",
         "popular6",
         "popular7",
     )*/

    val itemssub: MutableState<List<Filter.Filteritems.Filtersub>> = rememberSaveable {
        mutableStateOf(
            listOf(
                Filter.Filteritems.Filtersub("popular", "popular1", false),
                Filter.Filteritems.Filtersub("popular", "popular2", false),
                Filter.Filteritems.Filtersub("popular", "popular3", false),
                Filter.Filteritems.Filtersub("popular", "popular4", false),
                Filter.Filteritems.Filtersub("popular", "popular5", false),
                Filter.Filteritems.Filtersub("category", "categories of items1", false),
                Filter.Filteritems.Filtersub("category", "categories of items2", false),
                Filter.Filteritems.Filtersub("category", "categories of items3", false),
                Filter.Filteritems.Filtersub("category", "categories of items4", false),
                Filter.Filteritems.Filtersub("category", "categories of items5", false),
                Filter.Filteritems.Filtersub("category", "categories of items6", false),
                Filter.Filteritems.Filtersub("category", "categories of items7", false),
                Filter.Filteritems.Filtersub("brand", "brand of items1", false),
                Filter.Filteritems.Filtersub("brand", "brand of items2", false),
                Filter.Filteritems.Filtersub("brand", "brand of items3", false),
                Filter.Filteritems.Filtersub("brand", "brand of items4", false),
                Filter.Filteritems.Filtersub("brand", "brand of items5", false)

            ).map {
                Filter.Filteritems.Filtersub(
                    key = it.key,
                    filtersubname = it.filtersubname,
                    filtersubbolean = false
                )
            }
        )
    }

    val popularbrands: MutableState<ArrayList<Filter.Filteritems.Filtersub>> = mutableStateOf(
        arrayListOf()
    )

    var categoriesitems: MutableState<ArrayList<Filter.Filteritems.Filtersub>> = mutableStateOf(
        arrayListOf()
    )
    val branditems: MutableState<ArrayList<Filter.Filteritems.Filtersub>> = mutableStateOf(
        arrayListOf()
    )

    itemssub.value.forEach { itemssubn->
        when(itemssubn.key){
            "popular" ->{

                popularbrands.value.add(itemssubn)

            }
            "category" ->{

                categoriesitems.value.add(itemssubn)

            }
            "brand" ->{

                branditems.value.add(itemssubn)

            }
        }
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
                val pbrandsize: String

                if (filterItems == "items of Filter brand") {
                    pbrandsize = "( ${popularbrands.value.size} )"
                } else {
                    pbrandsize = ""
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
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                color = InputTextColor,
                thickness = 1.dp
            )



            if (expandedState) {
                Spacer(modifier = Modifier.padding(10.dp))

                Box(
                    modifier = Modifier
                        .height(heigh.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    LazyColumn(content = {
                        when (filterItems) {
                            "items of Filter categories" -> {

                                heigh = 44 * categoriesitems.value.size

                                itemsIndexed(categoriesitems.value) { index, filterIS ->

                                    categoriesitems = FilterSubItemsCategories(
                                        filterSubItems = categoriesitems,
                                        index = index
                                    )


                                    Spacer(modifier = Modifier.padding(7.dp))

                                }

                                Log.d("catcat", "is ${categoriesitems.value}")

                            }
                            "items of Filter brand" -> {

                                heigh = 44 * branditems.value.size + 330

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
                                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
                                        mainAxisSpacing = 15.dp,
                                        crossAxisSpacing = 15.dp,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight()
                                    ) {
                                        popularbrands.value.forEach { items ->

                                            InputChip(

                                                onClick = {
                                                    selectedInputChip = !selectedInputChip
                                                },
                                                label = {
                                                    Text(
                                                        items.filtersubname,
                                                        modifier = Modifier.padding(10.dp)
                                                    )
                                                },

                                                trailingIcon = {
                                                    Icon(
                                                        imageVector = Icons.Filled.Close,
                                                        contentDescription = "popular chip close",
                                                        modifier = Modifier.clickable { }
                                                    )

                                                },
                                                modifier = Modifier.height(40.dp),
                                                shape = RoundedCornerShape(20.dp),
                                                colors = InputChipDefaults.inputChipColors(
                                                    containerColor = SecondaryColor,
                                                    labelColor = PrimaryColor,
                                                ),
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



                                itemsIndexed(branditems.value) { index, filterIS ->

                                    FilterSubItemsBrand(
                                        filterSubItemsBra = branditems,
                                        index = index
                                    )


                                    Spacer(modifier = Modifier.padding(7.dp))

                                }
                                Log.d("catcat", "is ${branditems.value}")


                            }
                            "items of Filter price" -> {

                                heigh = 150

                                item {
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

                                        Row(
                                            horizontalArrangement = Arrangement.Center,
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
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = com.kr.components.ui.theme.FilterChip
                                                ),
                                                contentColor = PrimaryColor,

                                                ) {
                                                Text(
                                                    text = "${sliderPosition.start.toInt()} SAR",
                                                    modifier = Modifier.padding(
                                                        top = 10.dp,
                                                        start = 40.dp,
                                                        end = 25.dp
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.padding(7.dp))

                                            Surface(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .height(40.dp),
                                                shape = RoundedCornerShape(20.dp),
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = com.kr.components.ui.theme.FilterChip
                                                ),
                                                contentColor = PrimaryColor

                                            ) {
                                                Text(
                                                    text = "${sliderPosition.endInclusive.toInt()} SAR",
                                                    modifier = Modifier.padding(
                                                        top = 10.dp,
                                                        start = 40.dp,
                                                        end = 25.dp
                                                    )
                                                )
                                            }
                                        }

                                    }

                                }

                            }
                        }
                    })

                }

            }
        }
    }
}


///////////////////
/*
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

}
*/


//other use
////////////////////////////////////////////////////////////////////////


/*


@ExperimentalMaterialApi
@Composable
fun FilterItems(filterItems : String) {
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


    var categoriesitems by rememberSaveable {
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

    var branditems by rememberSaveable {
        mutableStateOf(
            listOf(
                "brand of items1",
                "brand of items2",
                "brand of items3",
                "brand of items4",
                "brand of items5",

                ).map {
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



            if (expandedState) {
                Spacer(modifier = Modifier.padding(10.dp))

                Box(modifier = Modifier
                    .height(heigh.dp)
                    .fillMaxWidth()
                    .background(Color.White)) {
                    LazyColumn(content = {
                        when(filterItems){
                            "items of Filter categories" ->{


                                heigh= 44 * categoriesitems.size
                                //  filteritemssub =categoriesitems

                                itemsIndexed(categoriesitems) { index,filterIS ->

                                    //       FilterSubItems(filterSubItems = categoriesitems , index = index)

                                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
                                    ) {



                                        Checkbox(
                                            checked = categoriesitems[index].isSelected,
                                            onCheckedChange = {
                                                categoriesitems =    categoriesitems.mapIndexed { j, item ->
                                                    if(index == j) {
                                                        item.copy(isSelected = !item.isSelected)
                                                    } else item
                                                }

                                            },
                                            colors = CheckboxDefaults.colors(
                                                checkedColor = SecondaryColor,
                                                checkmarkColor = PrimaryColor,
                                                uncheckedColor = PrimaryColor,
                                            ),
                                        )
                                        Text(
                                            text = categoriesitems[index].title,
                                            color = PrimaryColor,

                                            )

                                    }

                                    Spacer(modifier = Modifier.padding(7.dp))

                                }


                                Log.d("ListListcategory","is $categoriesitems")


                            }
                            "items of Filter brand"->{

                                heigh= 44 * branditems.size +330
                                //   filteritemssub =branditems

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
                                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
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
                                                label = {
                                                    Text(items,
                                                        modifier = Modifier.padding(10.dp)
                                                    )
                                                },

                                                trailingIcon = {
                                                    Icon(
                                                        imageVector = Icons.Filled.Close,
                                                        contentDescription = "popular chip close",
                                                        modifier = Modifier.clickable { }
                                                    )

                                                },
                                                modifier = Modifier.height(40.dp),
                                                shape = RoundedCornerShape(20.dp),
                                                colors = InputChipDefaults.inputChipColors(
                                                    containerColor = SecondaryColor,
                                                    labelColor = PrimaryColor,
                                                ),
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



                                itemsIndexed(branditems) { index, filterIS ->

                                    //    FilterSubItems(filterSubItems = categoriesitemssub , index = index)

                                    Row(verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.height(30.dp)
                                    ) {

                                        Checkbox(
                                            checked = branditems[index].isSelected,
                                            onCheckedChange = {
                                                branditems =
                                                    branditems.mapIndexed { j, items ->
                                                        if (filterIS.title == items.title) {
                                                            items.copy(isSelected = !items.isSelected)
                                                        } else items

                                                    }

                                            },
                                            colors = CheckboxDefaults.colors(
                                                checkedColor = SecondaryColor,
                                                checkmarkColor = PrimaryColor,
                                                uncheckedColor = PrimaryColor,
                                            ),

                                            )
                                        Text(
                                            text = branditems[index].title,
                                            color = PrimaryColor,

                                            )


                                    }



                                    Spacer(modifier = Modifier.padding(7.dp))

                                }


                                Log.d("ListListbrand","is $branditems")

                            }
                            "items of Filter price"->{

                                heigh= 150

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
                        }})

                    LazyColumn(
                        content = {


                            //////////////////////////////////////////////////////////////////////////////


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



*/
