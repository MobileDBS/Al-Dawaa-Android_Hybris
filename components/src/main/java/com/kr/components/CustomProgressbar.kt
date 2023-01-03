package com.kr.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.kr.components.ui.theme.OpacityBlackColor

@Composable
/*How to implement -->
 1- Create var visible by remember { mutableStateOf(true) }
2- change the value according to the visibility --> visible = true
3- call the fun  CustomProgressbar(isLoading = visible, imageLoader = imageLoader)*/
fun CustomProgressbar(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    imageLoader: ImageLoader
) {
    val context = LocalContext.current
    val LOADER_GIF = "https://media.giphy.com/media/cfuL5gqFDreXxkWQ4o/giphy.gif"
    if (isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(OpacityBlackColor)
        )
        {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(context).data(
                        data = LOADER_GIF
                    ).apply(block = {
                        size(Size.ORIGINAL)
                    }).build(), imageLoader = imageLoader
                ),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(10.dp)
                    .fillMaxSize()
            )
        }
    }

}

@Composable
fun RenderImage(
    url: Any?,
    modifier: Modifier = Modifier,
    imageLoader: ImageLoader,
    contentDescription: String?,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val context = LocalContext.current
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(
                data = url
            ).apply(block = {
                size(Size.ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = contentDescription,
        modifier = modifier,
        )


}
