package com.kr.components.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val LightColorPalette = lightColorScheme(
    primary = PrimaryColor,
    onPrimaryContainer = PrimaryColor,
    secondary = SecondaryColor,
    secondaryContainer = SecondaryColor ,
    background = BackgroundColorLight ,
    surface = SurfaceColorLight,
    error = ErrorColorLight ,
    onPrimary = WhiteColor ,
    onSecondary = PrimaryColor ,
    onBackground = BlackColor ,
    onSurface = BlackColor ,
    onError = WhiteColor ,

)
private val DarkColorPalette = darkColorScheme(
    primary = PrimaryColor,
    onPrimaryContainer = PrimaryColor,
    secondary = SecondaryColor,
    secondaryContainer = SecondaryColor ,
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
    val systemUiController = rememberSystemUiController()
    val colors = if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = PrimaryColor
        )
        DarkColorPalette
    } else {
        systemUiController.setSystemBarsColor(
            color = PrimaryColor
        )
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,

    )


}

