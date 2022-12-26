package com.kr.components.textFieldComponent

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.kr.components.R
import com.kr.components.ui.theme.InputHint
import com.kr.components.ui.theme.PrimaryColor

@Composable
fun TextFieldComponent(_value: TextFieldValue,
                       _onValueChange : (TextFieldValue) -> Unit,
                       _placeholder:@Composable (() -> Unit),
                       _leadingIcon:@Composable (()->Unit),
                       _trailingIcon:@Composable (()->Unit),
                       _modifier: Modifier = Modifier, _textStyle:TextStyle,
                       _colors : TextFieldColors){
    OutlinedTextField(
        value = _value,
        onValueChange = _onValueChange ,
        placeholder =  _placeholder ,
        modifier = _modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
        ),
        // //TODO:Ask shimaa which font.
        textStyle = TextStyle(color =_textStyle.color,fontFamily =_textStyle.fontFamily),
        colors = _colors,
        maxLines = 2,
        shape = RoundedCornerShape(35.dp),
        singleLine = true,
        leadingIcon = _leadingIcon,
        trailingIcon =  _trailingIcon

    )
}