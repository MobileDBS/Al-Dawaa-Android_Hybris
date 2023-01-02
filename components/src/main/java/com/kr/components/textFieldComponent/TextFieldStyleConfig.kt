package com.kr.components.textFieldComponent

import androidx.compose.ui.graphics.Color
import com.kr.components.ui.theme.*

data class TextFieldStyleConfig(
     var textColor: Color,
     var placeholderColor: Color,
    var bottomLabelColor: Color = PrimaryColor,
    var bottomLabelErrorColor: Color = ErrorColorDark,
    var bottomLabelSuccessColor: Color = SuccessColorDark,
    var borderColor: Color = Color.Transparent,
    var errorBorderColor: Color = ErrorColorDark,
    var successBorderColor: Color = SuccessColorDark,
    var disableBordereColor: Color = DisabledColorDark,
    var backgroundColor: Color ,
    var errorBackgroundColor: Color ,
    var successBackgroundColor: Color ,
    var disabledBackgroundColor: Color = DisabledColorLight
)

/*var bottomLabelColor: Color = PrimaryColor,
var bottomLabelErrorColor: Color = ErrorColorDark,
var bottomLabelSuccessColor: Color = SuccessColorDark,
var borderColor: Color = Color.Transparent,
var errorBorderColor: Color = ErrorColorDark,
var successBorderColor: Color = SuccessColorDark,
var disableBordereColor: Color = DisabledColorDark,
var backgroundColor: Color = DisabledColorLight,
var errorBackgroundColor: Color = DisabledColorLight,
var successBackgroundColor: Color = DisabledColorLight,
var disabledBackgroundColor: Color = DisabledColorLight*/

