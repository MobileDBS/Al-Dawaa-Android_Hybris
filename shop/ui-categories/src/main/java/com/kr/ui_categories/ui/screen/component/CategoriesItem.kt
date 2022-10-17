package com.kr.ui_categories.ui.screen.component

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.kr.categories_datasource.network.dto.ChildrenData
import com.kr.categories_domain.model.Categories


@Composable
fun CategoriesItems (result: Categories, onItemClick: (Categories) -> Unit) {
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

    Box(modifier = Modifier
        .height(160.dp)
        .width(160.dp)
        .background(Color.Transparent)
        .fillMaxSize()
        .clip(shape = RoundedCornerShape(24.dp))) {


        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(data = result.square_background_image).apply(block = {
                    size(Size.ORIGINAL)
                }).build(), imageLoader = imageLoader
            ),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )

        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .clickable { /*onItemClick(result)*/ }) {
            Spacer(modifier = Modifier.padding(5.dp))



            val col = result.category_name_text_color

            Text(text = result.name.toString(),
                color = col?.color!!,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))


            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(context).data(data = result.category_icon).apply(block = {
                        size(Size.ORIGINAL)
                    }).build(), imageLoader = imageLoader
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .padding(start = 15.dp)

            )

            Spacer(modifier = Modifier.padding(5.dp))
          val colo = result.additional_text_color
          Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Top, modifier = Modifier.fillMaxWidth(0.9f)) {
              Text(text = "See all",
                  color = colo?.color!!,
                  modifier = Modifier.padding(bottom = 5.dp)

                  )
              Image(
                  modifier = Modifier
                      .width(25.dp)
                      .height(25.dp)
                      .background(color = Color.Transparent),

                  painter = rememberAsyncImagePainter(
                      ImageRequest.Builder(context).data(data = com.kr.ui_categories.R.drawable.dropdown_new).apply(block = {
                          size(Size.ORIGINAL)
                      }).build(), imageLoader = imageLoader
                  ),
                  contentDescription = "Categories",
                  colorFilter = ColorFilter.tint(colo.color)

              )


          }

        }



    }

}


val String.color
    get() = Color(android.graphics.Color.parseColor(this))