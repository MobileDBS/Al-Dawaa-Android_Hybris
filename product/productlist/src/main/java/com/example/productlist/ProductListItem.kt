package com.example.productlist

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.ResourceFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.Shapes

@Composable
fun ProductListItem() {
   var itemToCart = rememberSaveable {
        mutableStateOf(1)
    }

    val context= LocalContext.current
    var offerText="1"
    val isLikedButtonPress = remember { mutableStateOf(false) }
    Surface(elevation = 8.dp,shape = RoundedCornerShape(20.dp), modifier = Modifier
        .padding(top = 4.dp, bottom = 6.dp)
        .fillMaxWidth())


    {
        Column(modifier = Modifier
            .height(325.dp)
            // .width(162.dp)
            .padding(8.dp)
            .fillMaxWidth()


            ){
            Row(
                Modifier
                    .padding(top = 3.dp)
                    .fillMaxWidth()
                   ) {
                Text(text = "$offerText+", textAlign = TextAlign.Center,color = Color.White, fontSize = 15.sp,
                    modifier = Modifier
                        .background(color = Color.Red, shape = CircleShape)
                        //    .width(36.dp)
                        //.fillMaxWidth()
                        .wrapContentSize()
                        .height(35.dp)
                        .padding(all = 8.dp)

                )
               // Spacer(modifier = Modifier.padding(1.dp))

                 Column(modifier = Modifier.wrapContentWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                     Image(
                         painter = painterResource(R.drawable.image),
                         contentDescription = "product image",
                         contentScale = ContentScale.Crop,
                         modifier = Modifier
                             .width(80.dp)
                             .height(116.dp)
                         , alignment = Alignment.Center
                     )
                 }

                Column(modifier = Modifier.fillMaxWidth()) {
                    IconButton(onClick = {
                        Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show()
                        isLikedButtonPress.value = !isLikedButtonPress.value
                    }, modifier = Modifier
                        .height(27.dp)
                        .width(25.dp)
                        .align(Alignment.End)
                    )
                    {

                        Icon(
                            painter = if (!isLikedButtonPress.value)
                                painterResource(R.drawable.unlike) else painterResource(
                                R.drawable.liked
                            ),
                            contentDescription = "likedproduct",
                            tint = colorResource(id = R.color.unlike_icon_color)
                        )
                    }
                }

            }
            Text(text = "Rimmel London", overflow = TextOverflow.Ellipsis,
                maxLines = 1, fontSize = 17.sp, modifier = Modifier.padding(0.dp), color = colorResource(id = R.color.dark_blue))
            Text(text = "Finish Bay Kit Lipstick Dark Nude (1 pack)", overflow = TextOverflow.Ellipsis,
                maxLines = 2, fontSize = 10.sp, modifier = Modifier.padding(0.dp), color = colorResource(id = R.color.dark_blue))
            Text(text = "SAR 55.00", overflow = TextOverflow.Ellipsis,
                maxLines = 1, fontSize = 16.sp, modifier = Modifier.padding(top=2.dp), color = colorResource(id = R.color.dark_blue))
            Text(text = "Buy 1 Get One Free", overflow = TextOverflow.Ellipsis,
                maxLines = 1, fontSize = 12.sp, modifier = Modifier.padding(top=0.dp), color = colorResource(id = R.color
                    .product_list_red))
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.arbahy),
                    contentDescription = "product image",
                    contentScale = ContentScale.Crop,
                )
                Text(text = "0.8 Loyalty Points", overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.End,
                    maxLines = 1, fontSize = 12.sp, modifier = Modifier.padding(start=4.dp,top=6.dp), color = colorResource(id = R.color.dark_blue))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.qitaf),
                    contentDescription = "product image",
                    contentScale = ContentScale.Crop, modifier = Modifier.padding(top = 4.dp)
                )
                Text(text = "0.8 Loyalty Points", overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    maxLines = 1, fontSize = 12.sp, modifier = Modifier
                        .padding(start=4.dp)
                        , color = colorResource(id = R.color.dark_blue))

            }

            Row( modifier = Modifier.fillMaxWidth()) {
                if (itemToCart.value>0)
                {   IconButton(onClick = { itemToCart.value--}) {
                    Icon(painter =painterResource(R.drawable.minus) , contentDescription = "minus")
                }
                }
                else
                    itemToCart.value=1

                Text(text =itemToCart.value.toString() ,textAlign = TextAlign.Center,
              modifier = Modifier.align(alignment = CenterVertically))
            IconButton(onClick = { itemToCart.value++ }) {
                    Icon(painter =painterResource(R.drawable.plus) , contentDescription = "plus")

                }

            Column(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.End)) {
                    Icon(painter = painterResource(R.drawable.cart), contentDescription = "cart",
                       )
                }
            }

            }
        }
    }
}