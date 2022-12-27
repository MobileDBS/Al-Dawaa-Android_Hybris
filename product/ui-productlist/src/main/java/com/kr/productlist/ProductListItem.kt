package com.kr.productlist

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.kr.product_domain.ProductListModel
import com.kr.ui_productlist.R

//@OptIn(ExperimentalMaterialApi::class)
@Composable

fun DisplayProductList() {

    LazyVerticalGrid(
        state = rememberLazyGridState(),
        columns = GridCells.Fixed(2),
        userScrollEnabled = true,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .scrollable(rememberLazyGridState(), orientation = Orientation.Vertical),
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 8.dp,
            end = 16.dp,
            bottom = 8.dp
        ),
        content = {
            items(getProductItemData()) {
                    it ->
                ProductListItem(it)
            }
        }
    )
}
@Composable
//fun ProductListItem(showBottomSheet: (Boolean) -> Unit)
fun ProductListItem(result:ProductListModel){
    val imagePainter= rememberAsyncImagePainter(model = result.productImage)
    val itemToCart = rememberSaveable {
        mutableStateOf(1)
    }
    val context = LocalContext.current
    var offerText = "1"
    val isLikedButtonPress = remember { mutableStateOf(false) }
    val isItemInProductList = remember { mutableStateOf(true) }

    Surface(
        shadowElevation  = 8.dp, shape = RoundedCornerShape(20.dp), modifier = Modifier
            .padding(top = 4.dp, bottom = 4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    )


    {
        Column(
            modifier = Modifier
                .height(325.dp)
                .width(172.dp)
                .padding(8.dp)
                /* .fillMaxWidth()
                 .wrapContentHeight()*/
                //  .wrapContentSize()
                //  .alpha(0.5f)
        ) {
            Row(
                Modifier
                    .padding(top = 3.dp)
                    .fillMaxWidth()
            ) {
              /*  Box() {
                    Image(
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp),
                        //.align(Alignment.CenterHorizontally),
                          painter = painterResource(R.drawable.image),

                      //  painter=imagePainter,
                        contentDescription = "product image",
                        contentScale = ContentScale.Crop,
                    )
                }
                Box() {
                    Text(
                        text = "${result.offerNumber}",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .background(color = Color.Red, shape = CircleShape)
                            //    .width(36.dp)
                            //.fillMaxWidth()
                            .wrapContentSize()
                            .height(35.dp)
                            .padding(all = 8.dp)

                    )
                }
                Box() {
                    IconButton(
                        modifier = Modifier
                            .height(27.dp)
                            .width(27.dp)
                          //  .align(Alignment.End)
                                ,
                        onClick = {
                            //added here
                            //   showBottomSheet ( true)
                            if (isItemInProductList.value){
                                Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show()
                                isLikedButtonPress.value = !isLikedButtonPress.value
                            }

                        }
                    )
                    {

                        Icon(
                            painter = if (!isLikedButtonPress.value)
                                painterResource(R.drawable.unlike)
                            else{
                                painterResource(R.drawable.liked)
                            },
                            contentDescription = "likedproduct",
                            tint = colorResource(id = R.color.unlike_icon_color),
                        )
                    }
                }*/
                Text(
                    text = "${result.offerNumber}",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .background(color = Color.Red, shape = CircleShape)
                        //    .width(36.dp)
                        //.fillMaxWidth()
                        .wrapContentSize()
                        .height(35.dp)
                        .padding(all = 8.dp)

                )
           //      Spacer(modifier = Modifier.padding(2.dp))

                Column(
                    modifier = Modifier.wrapContentWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .width(80.dp)
                            .height(116.dp)
                            //.align(Alignment.CenterHorizontally),
                                ,
                        painter = painterResource(R.drawable.image),

                      //  painter=imagePainter,
                        contentDescription = "product image",
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        modifier = Modifier
                            .height(27.dp)
                            .width(27.dp)
                            .align(Alignment.End),
                        onClick = {
                            //added here
                         //   showBottomSheet ( true)
                            if (isItemInProductList.value){
                                Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show()
                                isLikedButtonPress.value = !isLikedButtonPress.value
                            }

                        }
                    )
                    {

                        Icon(
                            painter = if (!isLikedButtonPress.value)
                                painterResource(R.drawable.unlike)
                            else{
                                painterResource(R.drawable.liked)
                                },
                            contentDescription = "likedproduct",
                            tint = colorResource(id = R.color.unlike_icon_color),
                        )
                    }
                }

            }
            Text(
                text = "${result.productName}",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = 17.sp,
                modifier = Modifier.padding(0.dp),
                color = colorResource(id = R.color.dark_blue)
            )
            Text(
                text = "${result.productDescription}",
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                fontSize = 10.sp,
                modifier = Modifier.padding(0.dp),
                color = colorResource(id = R.color.dark_blue)
            )
            Text(
                text = "SAR ${result.productPrice}",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 2.dp),
                color = colorResource(id = R.color.dark_blue)
            )
            Text(
                text = "${result.offerString}",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 0.dp),
                color = colorResource(
                    id = R.color
                        .product_list_red
                )
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.arbahy),
                    contentDescription = "product image",
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = "${result.arbahiLoyaltyPoint}",
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.End,
                    maxLines = 1,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 4.dp, top = 6.dp),
                    color = colorResource(id = R.color.dark_blue)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.qitaf),
                    contentDescription = "product image",
                    contentScale = ContentScale.Crop, modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "${result.qitafLoyaltyPoint}", overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    maxLines = 1, fontSize = 12.sp, modifier = Modifier
                        .padding(start = 4.dp), color = colorResource(id = R.color.dark_blue)
                )

            }

            Row(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp)
                        .align(Alignment.Bottom)
                ) {
                    IconButton(
                        onClick = {
                            if (itemToCart.value > 1) itemToCart.value--
                            else
                                itemToCart.value = 1
                        }, Modifier
                            .height(20.dp)
                            .width(20.dp)
                            .align(alignment = CenterVertically)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "minus"
                        )
                    }


                    Text(
                        text = itemToCart.value.toString(), textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(alignment = CenterVertically)
                            .padding(start = 8.dp, end = 8.dp)
                    )
                    IconButton(
                        onClick = { itemToCart.value++ }, Modifier
                            .height(20.dp)
                            .width(20.dp)
                            .align(alignment = CenterVertically)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.plus),
                            contentDescription = "plus",
                        )

                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Bottom)
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ }, modifier = Modifier
                                .align(Alignment.End)
                                .height(27.dp)
                                .width(27.dp)
                                .padding(end = 2.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.cart),
                                contentDescription = "cart",
                            )
                        }
                    }

                }
            }
        }
    }
}

 fun getProductItemData():MutableList<ProductListModel>{
 val productData : MutableList<ProductListModel> = mutableListOf()
    productData.add(
        ProductListModel("1+","Forever Lip","Finish Mat Lip Gloss Dark Node"
    ,"205","Buy 1 get two free",
            "https://thumbs.dreamstime.com/b/pills-medicine-background-25754120.jpg",
            "1.25 Loyalty points","1.25 Loyalty points"))
     productData.add(
         ProductListModel("1+","Forever Lip","Finish Mat Lip Gloss Dark Node"
             ,"205","Buy 1 get two free",
             "https://thumbs.dreamstime.com/b/pills-medicine-background-25754120.jpg",
             "1.25 Loyalty points","1.25 Loyalty points"))
     productData.add(
         ProductListModel("1+","Forever Lip","Finish Mat Lip Gloss Dark Node"
             ,"205","Buy 1 get two free",
             "https://thumbs.dreamstime.com/b/pills-medicine-background-25754120.jpg",
             "1.25 Loyalty points","1.25 Loyalty points"))
     productData.add(
         ProductListModel("1+","Forever Lip","Finish Mat Lip Gloss Dark Node"
             ,"205","Buy 1 get two free",
             "https://thumbs.dreamstime.com/b/pills-medicine-background-25754120.jpg",
             "1.25 Loyalty points","1.25 Loyalty points"))

    return productData
}