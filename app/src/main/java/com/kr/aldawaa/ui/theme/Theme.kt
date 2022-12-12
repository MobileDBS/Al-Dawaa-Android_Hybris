package com.kr.aldawaa.ui.theme

import android.view.Window
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryColor,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryColor ,
    background = BackgroundColorLight ,
    surface = SurfaceColorLight,
    error = ErrorColorLight ,
    onPrimary = WhiteColor ,
    onSecondary = PrimaryColor ,
    onBackground = BlackColor ,
    onSurface = BlackColor ,
    onError = WhiteColor ,
)
private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryColor,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryColor ,
    background = BackgroundColorDark ,
    surface = SurfaceColorDark,
    error = ErrorColorDark ,
    onPrimary = PrimaryColor ,
    onSecondary = PrimaryColor ,
    onBackground = WhiteColor ,
    onSurface = WhiteColor ,
    onError = BlackColor ,
    )

@Composable
fun AlDawaaHybrisTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,

    )
}

