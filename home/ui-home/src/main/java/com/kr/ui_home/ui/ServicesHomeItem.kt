package com.kr.ui_home.ui

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.WhiteColor
import com.kr.services_domain.model.Services

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesHomeItem(result: Services, onItemClick: (Services) -> Unit) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Surface(
        shape = RoundedCornerShape(20.dp), modifier = Modifier
            .padding(top = 4.dp, bottom = 6.dp).background(color =  WhiteColor),
        shadowElevation = 5.dp , onClick = {onItemClick(result)})
    {
        Column(modifier = Modifier.width(160.dp)
        ){
            Box(modifier = Modifier.fillMaxWidth()
                .size(150.dp)
                .clip(RoundedCornerShape(20.dp))
            ) {
                Image(

                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(context).data(data = result.image).apply(block = {
                            size(Size.ORIGINAL)
                        }).build(), imageLoader = imageLoader
                    ),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier.height(160.dp)

                )
            }


             androidx.compose.material.Text(
                text = result.title,
                textAlign = TextAlign.Center,
                color = PrimaryColor,
                fontSize = 16.sp,
                 modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp)

            )


        }
    }
}

