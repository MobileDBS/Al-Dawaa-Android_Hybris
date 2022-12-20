package com.kr.ui_filter.component

import android.util.Log

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.SecondaryColor
import com.kr.product_datasource.dto.FilterModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSubItemsCategories(filterSubItems : MutableState<ArrayList<FilterModel.Filteritems.Filtersub>>, index :Int):MutableState<ArrayList<FilterModel.Filteritems.Filtersub>> {
 //   val context = LocalContext.current
   // val checkboxvalue = remember { mutableStateOf(false) }


    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
        ) {

        Checkbox(
            checked = filterSubItems.value[index].filtersubbolean,
            onCheckedChange = {

                filterSubItems.value = filterSubItems.value.mapIndexed { j, item ->
                    if (index == j) {
                        item.copy(filtersubbolean = !item.filtersubbolean)
                    } else item

                } as ArrayList<FilterModel.Filteritems.Filtersub>
            },

            colors = CheckboxDefaults.colors(
                checkedColor = SecondaryColor,
                checkmarkColor = PrimaryColor,
                uncheckedColor = PrimaryColor,
            )
        )
            Text(
                text = filterSubItems.value[index].filtersubname,
                color = PrimaryColor,

                )


     // filterSubItems.value.containsAll(listOf(Filter.Filteritems.Filtersub(filtersubbolean = true, filtersubname = filterSubItems.value[index])))

    }

    Log.d("ListList","is ${filterSubItems.value}")

    return filterSubItems
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSubItemsBrand(filterSubItemsBra : MutableState<ArrayList<FilterModel.Filteritems.Filtersub>>, index :Int) {
    //   val context = LocalContext.current
    // val checkboxvalue = remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
        ) {

        Checkbox(
            checked = filterSubItemsBra.value[index].filtersubbolean,
            onCheckedChange = {
                filterSubItemsBra.value = filterSubItemsBra.value.mapIndexed { j, item ->
                    if (index == j) {
                        item.copy(filtersubbolean = !item.filtersubbolean)
                    } else item

                } as ArrayList<FilterModel.Filteritems.Filtersub>
                //   categoriesitems[index].isSelected==it
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
            text = filterSubItemsBra.value[index].filtersubname,
            color = PrimaryColor,

            )




    }

    Log.d("ListList","is ${filterSubItemsBra.value}")

}
