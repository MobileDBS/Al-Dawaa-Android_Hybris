package com.kr.ui_categories.ui.categoriesdetailsui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import com.kr.components.ui.theme.InputColor
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.WhiteColor


@Composable
fun CategoryDetailsSubItems(categoryIS : String) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(color = Color.White)
            ,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp,

                ),
          //  border = BorderStroke(1.dp , color = InputColor),
            colors = ButtonDefaults.outlinedButtonColors(Color.Unspecified),
            shape = RoundedCornerShape(20.dp),

            onClick = {

            }


        ) {
            Text(
                text = categoryIS,
                color = PrimaryColor,

                )

        }


    }
