package com.example.productlist

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.Shapes

@Composable
fun ProductListItem() {
//    var offerText by remember {
//        mutableStateOf("")
//    }
    val context= LocalContext.current
    var offerText="1"
    val isLikedButtonPress = remember { mutableStateOf(false) }
    Surface(elevation = 8.dp,shape = RoundedCornerShape(20.dp), modifier = Modifier
        .padding(top = 4.dp))

    {
        Column(modifier = Modifier
            .height(325.dp)
           // .width(162.dp)
            .padding(9.dp)
          //  .wrapContentSize()
            ){
            Row(
                Modifier
                    .padding(top = 3.dp)
                  ///  .fillMaxWidth()
                   ) {
                Text(text = "$offerText+", textAlign = TextAlign.Center,color = Color.White, fontSize = 15.sp,
                    modifier = Modifier
                        .background(color = Color.Red, shape = CircleShape)
                    //    .width(36.dp)
                       //.fillMaxWidth()
                        .wrapContentSize()
                        .height(35.dp)
                        .padding(top = 8.dp, start = 8.dp, bottom = 4.dp, end = 8.dp)

                )
               // Spacer(modifier = Modifier.padding(1.dp))

                    Image(
                        painter = painterResource(R.drawable.image),
                        contentDescription = "product image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(100.dp)
                            .height(116.dp), alignment = Alignment.Center


                        )
                IconButton(onClick = {
                    Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show()
                    isLikedButtonPress.value = !isLikedButtonPress.value
                }, modifier = Modifier
                    .height(27.dp)
                    .width(25.dp)
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
    }
}