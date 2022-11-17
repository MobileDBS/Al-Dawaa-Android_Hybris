package com.kr.ui_filter.ui.filterui.component

import android.util.Log
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.SecondaryColor
import okhttp3.internal.toImmutableList

@Composable
fun FilterSubItemsCategories(filterSubItems : MutableState<List<FilterState>>, index :Int):MutableState<List<FilterState>> {
 //   val context = LocalContext.current
   // val checkboxvalue = remember { mutableStateOf(false) }


    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
        ) {

        Checkbox(
            checked = filterSubItems.value[index].isSelected,
            onCheckedChange = {

                filterSubItems.value = filterSubItems.value.mapIndexed { j, item ->
                    if (index == j) {
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
                text = filterSubItems.value[index].title,
                color = PrimaryColor,

                )


      filterSubItems.value.containsAll(listOf(FilterState(isSelected = true, title = filterSubItems.value[index].title)))

    }
    Log.d("ListList","is ${filterSubItems.value.contains(FilterState(isSelected = true, title = filterSubItems.value[index].title))}")

    Log.d("ListList","is ${filterSubItems.value}")

    return filterSubItems
}


@Composable
fun FilterSubItemsBrand(filterSubItemsBra : MutableState<List<FilterState>>, index :Int) {
    //   val context = LocalContext.current
    // val checkboxvalue = remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
        ) {

        Checkbox(
            checked = filterSubItemsBra.value[index].isSelected,
            onCheckedChange = {
                filterSubItemsBra.value = filterSubItemsBra.value.mapIndexed { j, item ->
                    if (index == j) {
                        item.copy(isSelected = !item.isSelected)
                    } else item

                }
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
            text = filterSubItemsBra.value[index].title,
            color = PrimaryColor,

            )




    }

    Log.d("ListList","is ${filterSubItemsBra.value}")

}
