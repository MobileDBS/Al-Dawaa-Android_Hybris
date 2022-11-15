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

@Composable
fun FilterSubItemsCategories(filterSubItems : List<String>, index :Int) {
 //   val context = LocalContext.current
   // val checkboxvalue = remember { mutableStateOf(false) }
    var categoriesitems by rememberSaveable {
        mutableStateOf(
            (filterSubItems).map {
                FilterState(
                    title = it,
                    isSelected = false
                )
            }
        )
    }
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
        ) {

        Checkbox(
            checked = categoriesitems[index].isSelected,
            onCheckedChange = {

                categoriesitems = categoriesitems.mapIndexed { j, item ->
                    if(index == j) {
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

    Log.d("ListList","is $categoriesitems")

}


@Composable
fun FilterSubItemsBrand(filterSubItemsBra : List<String>, index :Int) {
    //   val context = LocalContext.current
    // val checkboxvalue = remember { mutableStateOf(false) }
    var branditems by rememberSaveable {
        mutableStateOf(
            (filterSubItemsBra).map {
                FilterState(
                    title = it,
                    isSelected = false
                )
            }
        )
    }
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)
        ) {

        Checkbox(
            checked = branditems[index].isSelected,
            onCheckedChange = {

                branditems =    branditems.mapIndexed { j, item ->
                    if(index == j) {
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
            text = branditems[index].title,
            color = PrimaryColor,

            )




    }

    Log.d("ListList","is $branditems")

}
