package com.kr.ui_categories.ui.categoriesdetailsui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

@Composable
fun CategoryDetailsSubItems(categoryIS : String){




    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(40.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 2.dp,

        ),
        colors = ButtonDefaults.outlinedButtonColors(Color.Transparent),
        shape = RoundedCornerShape(20.dp),

        onClick = {

        }


        ) {
       Text(
            text = categoryIS,
            color = Color.Black,

        )

    }

}