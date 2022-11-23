package com.kr.ui_services.ui.componant.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CapturePictureButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
  //  val color = if (isPressed) Color.Blue else Color.Black
  //  val contentPadding = PaddingValues(if (isPressed) 8.dp else 12.dp)

        IconButton(onClick =  onClick ,
            modifier = modifier.background(Color.Transparent)) {

                Icon(
                    painter = painterResource(id =com.kr.ui_services.R.drawable.camerabutton ),

                    contentDescription = "upload photo",
                    modifier = Modifier.fillMaxSize().background(Color.Transparent)
                )

            }

        }




@Preview
@Composable
fun PreviewCapturePictureButton() {
    Scaffold(
        modifier = Modifier
            .size(125.dp)
            .wrapContentSize()
    ) { innerPadding ->
        CapturePictureButton(
            modifier = Modifier
                .padding(innerPadding)
                .size(100.dp)
        )
    }
}
