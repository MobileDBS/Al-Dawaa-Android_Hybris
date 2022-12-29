package com.kr.ui_services.ui

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.WhiteColor
import com.kr.services_domain.model.Services

@Composable
fun ServicesItem(result: Services, onItemClick: (Services) -> Unit) {

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
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                start = 16.dp, end = 16.dp
            )
        , shadowElevation = 5.dp,
        shape = RoundedCornerShape(28.dp),
        color = WhiteColor
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp).background(WhiteColor)) {
               Row(modifier = Modifier
                   .wrapContentHeight()
                   .wrapContentWidth()) {

                   Icon(
                       painter = rememberAsyncImagePainter(
                           ImageRequest.Builder(context).data(data = result.icon).apply(block = {
                               size(Size.ORIGINAL)
                           }).build(), imageLoader = imageLoader
                       ),
                       contentDescription = null,
                       modifier = Modifier
                           .height(24.dp)
                           .width(24.dp),
                       tint = Color.Unspecified

                       )

                   Column( modifier = Modifier.padding(start = 10.dp ),
                   ) {
                       Text(text = result.title,
                           textAlign = TextAlign.Start ,
                           modifier = Modifier
                               .wrapContentWidth()
                               .wrapContentHeight().padding(bottom = 5.dp),
                              style = MaterialTheme.typography.titleSmall, color = PrimaryColor)

                       Text(text = result.description,
                           textAlign = TextAlign.Start ,
                           modifier = Modifier
                               .wrapContentWidth()
                               .wrapContentHeight().padding(bottom = 5.dp),
                           style = MaterialTheme.typography.bodyLarge, color = PrimaryColor)



                   }

               }



           }
    }

}