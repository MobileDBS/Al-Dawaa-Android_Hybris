package com.kr.components.ui.theme

import androidx.compose.ui.graphics.Color

enum class BTNSTATE (val bordercolor :Color, val textcolor : Color, val enablestate :Boolean) {
    ACTIVE (PrimaryColor, PrimaryColor, true) ,
    INACTIVE (BorderGray, BorderGray, false),
}