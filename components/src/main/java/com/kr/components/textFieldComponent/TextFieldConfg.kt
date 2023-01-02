package com.kr.components.textFieldComponent

import androidx.compose.ui.graphics.Color
import com.kr.components.ui.theme.*

data class TextFieldData(
    var text: String = "",
    var isValid: Boolean = false,
    var state: STATE = STATE.NORMAL
)


enum class STATE(var labelText: String?) {
    NORMAL(null),
    DISABLED(null),
    ERROR(labelText = null),
    SUCCESS(labelText = null)
}

enum class TEXTFIELDSTYLE()
 {
    DEFAULT,
    CUSTOM
}

fun getTextStyleField(styleType: TEXTFIELDSTYLE, customStyle:TextFieldStyleConfig?): TextFieldStyleConfig {
    val style = when (styleType){
        TEXTFIELDSTYLE.DEFAULT -> TextFieldStyleConfig(textColor = PrimaryColor,
            placeholderColor = InputColor,  backgroundColor = Color.White,
            errorBackgroundColor = ErrorColorDark,
            successBackgroundColor = SuccessColorDark)
        TEXTFIELDSTYLE.CUSTOM -> customStyle
    }
    return style ?: TextFieldStyleConfig(textColor = PrimaryColor,
        placeholderColor = InputColor,  backgroundColor = Color.White,
        errorBackgroundColor = ErrorColorDark,
        successBackgroundColor = SuccessColorDark)
}
