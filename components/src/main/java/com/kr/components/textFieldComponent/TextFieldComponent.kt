package com.kr.components.textFieldComponent

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.kr.components.textFieldComponent.TextFieldComponent
import com.kr.components.ui.theme.PrimaryColor

@Composable
fun TextFieldComponent(data: TextFieldData,
                       _value: TextFieldValue,
                       _onValueChange : (TextFieldValue) -> Unit,
                       _placeholder:@Composable (() -> Unit),
                       _leadingIcon:@Composable (()->Unit),
                       _trailingIcon:@Composable (()->Unit),
                       styleType: TEXTFIELDSTYLE,
                       customStyle:TextFieldStyleConfig?,
                       _modifier: Modifier = Modifier, _textStyle:TextStyle,
                       _colors : TextFieldColors){
    val style:TextFieldStyleConfig =  getTextStyleField(styleType,customStyle)
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
        textStyle = TextStyle(color = style.textColor,fontFamily =_textStyle.fontFamily),
        colors = _colors,
        maxLines = 2,
        shape = RoundedCornerShape(35.dp),
        singleLine = true,
        leadingIcon = _leadingIcon,
        trailingIcon =  _trailingIcon)
 var test = when(data.state){
        STATE.NORMAL-> {

        //TODO: Draw normal UI
        }
        STATE.DISABLED-> {
        //TODO: Draw disabled UI
        }
        STATE.ERROR-> {
        //TODO: Draw error UI
        }
        STATE.SUCCESS-> {
        //TODO: Draw success UI
        }
     else -> {//TODO: Draw normal UI
      }
    }
/*
 var backgroundColor = when(data.state){
        STATE.NORMAL-> {
           backgroundColor
        }
        STATE.DISABLED-> {
            disabledBackgroundColor
        }
        STATE.ERROR-> {
           errorBackgroundColor
        }
        STATE.SUCCESS-> {
            successBackgroundColor
        }
        else -> {//TODO: Draw normal UI
        }
    }
    var bottomLabelColor = when(data.state){
        STATE.NORMAL-> {
            //TODO: Draw normal UI
        }
        STATE.DISABLED-> {
            //TODO: Draw disabled UI
        }
        STATE.ERROR-> {
            //TODO: Draw error UI
        }
        STATE.SUCCESS-> {
            //TODO: Draw success UI
        }
        else -> {//TODO: Draw normal UI
        }
    }
    var borderColor = when(data.state){
        STATE.NORMAL-> {
            //TODO: Draw normal UI
        }
        STATE.DISABLED-> {
            //TODO: Draw disabled UI
        }
        STATE.ERROR-> {
            //TODO: Draw error UI
        }
        STATE.SUCCESS-> {
            //TODO: Draw success UI
        }
        else -> {//TODO: Draw normal UI
        }
    }
*/

}
//TODO: make for each var depends on the status its own value using when
//private var backgroundView = when ()