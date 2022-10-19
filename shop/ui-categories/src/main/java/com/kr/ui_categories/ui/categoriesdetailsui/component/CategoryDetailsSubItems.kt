package com.kr.ui_categories.ui.categoriesdetailsui.component

import androidx.compose.foundation.BorderStroke
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
import com.kr.components.ui.theme.PrimaryColor

@Composable
fun CategoryDetailsSubItems(categoryIS : String) {





        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .clip(shape = RoundedCornerShape(20.dp)),
            border = BorderStroke(1.dp, color = PrimaryColor
            ),
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
