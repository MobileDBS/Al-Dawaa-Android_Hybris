package com.kr.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kr.components.ui.theme.BTNSTATE
import com.kr.components.ui.theme.ShapeBigButtons

@Composable
fun CustomOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    statue: BTNSTATE,
    elevation: ButtonElevation? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contenttext: String = "",
    icon: Painter? = null
) {
    OutlinedButton(onClick = onClick ,
    modifier = modifier.fillMaxWidth(0.9f)
        .height(53.dp)
        .clip(shape = ShapeBigButtons.small),
    enabled = statue.enablestatue,
    shape = ShapeBigButtons.small,
    colors = ButtonDefaults.outlinedButtonColors(
        contentColor = statue.textcolor,
        disabledContentColor = statue.textcolor
    ),
    elevation = elevation,
    border = BorderStroke(width = 2.dp,statue.bordercolor),
        interactionSource = interactionSource,
        content = {
            if (icon != null) {
                Icon(painter = icon, contentDescription = "iconLogo")
            }
            Text(
                text = contenttext,
                fontSize = 20.sp,
            )
        }
    )


}

