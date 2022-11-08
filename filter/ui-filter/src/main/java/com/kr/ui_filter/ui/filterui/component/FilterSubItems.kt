package com.kr.ui_filter.ui.filterui.component

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.SecondaryColor

@Composable
fun FilterSubItems(filterSubItems : String) {
    val context = LocalContext.current
    val checkboxvalue = remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(30.dp)) {


        Checkbox(
            checked = checkboxvalue.value,
            onCheckedChange = {
                checkboxvalue.value = it
                Toast.makeText(
                    context,
                    "user checked : ${checkboxvalue.value}",
                    Toast.LENGTH_SHORT
                ).show()

            },
            colors = CheckboxDefaults.colors(
                checkedColor = SecondaryColor,
                checkmarkColor = PrimaryColor,
                uncheckedColor = PrimaryColor,
            )
        )
            Text(
                text = filterSubItems,
                color = PrimaryColor,

                )




    }
}
