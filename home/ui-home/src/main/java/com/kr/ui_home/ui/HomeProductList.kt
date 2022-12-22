package com.kr.ui_home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.productlist.ProductListItem
import com.kr.productlist.getProductItemData
import com.kr.ui_home.R

@Composable
fun HomeProductList(navController: NavController)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
            // .align(Alignment.Start)
        ) {
            Text(
                text = "Don't miss this offers",
                // textAlign = TextAlign.Center,
                color = colorResource(id = R.color.navy),
                fontSize = 16.sp,
                //   fontWeight = FontWeight.Bold,
                modifier = Modifier
                    //  .wrapContentSize()
                    .padding(all = 8.dp)

            )
            Column(Modifier.fillMaxWidth().align(Alignment.CenterVertically)) {
                Row(modifier = Modifier.align(Alignment.End)) {
                    Text(
                        text="See all",
                        color = colorResource(id = R.color.navy),
                        fontSize = 16.sp,
                        //      fontWeight= FontWeight.Bold,
                        //  textAlign = TextAlign.Center,

                        modifier = Modifier.padding(end=2.dp, top = 4.dp)
                            .align(Alignment.Bottom)
                            .clickable(true,"",null, onClick = {navController.navigate("Product_List")})

                    )
                    IconButton(
                        onClick = { navController.navigate("Product_List")}, modifier = Modifier
                            .height(27.dp)
                            .width(27.dp)
                            .padding(end = 2.dp)
                        //.align(Alignment.Center)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = "arrow",

                            )
                    }
                }



            }


        }

        Box(modifier = Modifier
            .fillMaxWidth()
        ) {
            LazyHorizontalGrid(
                state = rememberLazyGridState(),
                rows = GridCells.Fixed(1),
                userScrollEnabled = true,
                reverseLayout = false,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement =Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                   .height(350.dp)
                    .align(Alignment.TopStart)
                    .scrollable(
                        rememberLazyGridState(),
                        orientation = Orientation.Horizontal
                    )
                // content padding
                , contentPadding = PaddingValues(
                    start =8.dp,
                    top = 8.dp,
                    end = 8.dp,
                    bottom =8.dp
                ),
                content = {

                    items(getProductItemData()) {
                        ProductListItem(it)
                    }

                }
            )
        }



    }
}