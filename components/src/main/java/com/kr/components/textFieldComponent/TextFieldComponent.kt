package com.kr.components.textFieldComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kr.components.ui.theme.ErrorColor

@Composable
fun TextFieldComponent(
    data: TextFieldData,
    _onValueChange: (String) -> Unit,
    _placeholderText: String,
    _leadingIcon: @Composable (() -> Unit)?,
    _trailingIcon: @Composable (() -> Unit)?,
    styleType: TEXTFIELDSTYLE,
    customStyle: TextFieldStyleConfig?,
    _modifier: Modifier = Modifier,
) {
    val style: TextFieldStyleConfig = getTextStyleField(styleType, customStyle)
    val backgroundColor = when (data.state) {
        STATE.NORMAL -> {
            style.backgroundColor
        }
        STATE.DISABLED -> {
            style.disabledBackgroundColor
        }
        STATE.ERROR -> {
            style.errorBackgroundColor
        }
        STATE.SUCCESS -> {
            style.successBackgroundColor
        }
        else -> {
            style.backgroundColor
        }
    }
    val bottomLabelColor = when (data.state) {
        STATE.NORMAL -> {
            style.bottomLabelColor
        }
        STATE.DISABLED -> {
            style.disableBordereColor
        }
        STATE.ERROR -> {
            style.bottomLabelErrorColor
        }
        STATE.SUCCESS -> {
            style.bottomLabelSuccessColor
        }
        else -> {
            style.bottomLabelColor
        }
    }
    val borderColor = when (data.state) {
        STATE.NORMAL -> {
            style.borderColor
        }
        STATE.DISABLED -> {
            style.disableBordereColor
        }
        STATE.ERROR -> {
            style.errorBackgroundColor
        }
        STATE.SUCCESS -> {
            style.successBorderColor
        }
        else -> {
            style.borderColor
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Transparent)
    ){

        OutlinedTextField(
            value =  data.text,
            onValueChange = _onValueChange,
            placeholder = {
                        Text(text = _placeholderText )
            },
            modifier = _modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
            ),
            // //TODO:Ask shimaa which font.
         //   , fontFamily = _textStyle.fontFamily)
            textStyle = TextStyle(color = style.textColor),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
                focusedLabelColor = bottomLabelColor,
                unfocusedLabelColor = bottomLabelColor,
                containerColor = backgroundColor
            ),
            maxLines = 2,
            shape = RoundedCornerShape(35.dp),
            singleLine = true,
            leadingIcon = _leadingIcon,
            trailingIcon = _trailingIcon)
/*        Text(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(alignment = Alignment.Start)
                .padding(start = 20.dp),
            text = "name error or empty",
            color = ErrorColor,
            fontSize = 12.sp
        )*/
    }


}
