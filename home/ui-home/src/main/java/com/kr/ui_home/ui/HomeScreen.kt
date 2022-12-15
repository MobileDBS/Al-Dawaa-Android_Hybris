package com.kr.ui_home.ui

import android.view.Gravity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
import com.kr.services_domain.model.Services


@Composable
fun HomeScreen(navController: NavController) {

    Column(modifier = Modifier.padding(16.dp)) {

        Row(modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Services", color = PrimaryColor ,
                textAlign = TextAlign.Start)

            Text(text = "See All", color = PrimaryColor ,textAlign = TextAlign.End)

        }//end row

        LazyRow(
            state = rememberLazyListState(),
            userScrollEnabled = true,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(getServicesData()) { item ->
                    ServicesHomeItem(item) {

                    }
                }

            }
        )
    }

}

private fun getServicesData(): List<Services> {
    val services: ArrayList<Services> = arrayListOf()
    services.add(
        Services(1 , "Booking", "https://thumbs.dreamstime.com/b/pills-medicine-background-25754120.jpg" ,  "https://cdn-icons.flaticon.com/svg/3917/3917032.svg?token=exp=1671093560~hmac=e2e1622fccfd8b04fe13822938d84757" , "Get appointments face-to-face or through video calls."))
    services.add(Services(2 , "Health services", "https://prnewswire2-a.akamaihd.net/p/1893751/sp/189375100/thumbnail/entry_id/0_x9ajkzs1/def_height/2700/def_width/2700/version/100012/type/1" , "https://cdn-icons.flaticon.com/svg/3916/3916598.svg?token=exp=1671093560~hmac=492d2a9f7eeede3d89fe8c5c9ef42d7f" , "Make your life easier with many of the services we offer."))
    services.add(
        Services(3 , "Delivery services", "https://www.arbd.com/wp-content/uploads/2015/07/AdobeStock_130050329.jpeg" , "https://cdn-icons.flaticon.com/svg/3917/3917688.svg?token=exp=1671093560~hmac=9caa1f2eb10a47f956753ab3401160fa", "Track your order, see delivery details and order&receive, FAQ"))
    services.add(
        Services(4 , "Blog", "https://media.istockphoto.com/photos/prescription-drugs-picture-id183369961?k=6&m=183369961&s=612x612&w=0&h=uYQDTxgWxnhsAnjJ-KIIQtEd-ljQwit5OuIcnFtGU3Y=" , "https://cdn-icons.flaticon.com/svg/3917/3917058.svg?token=exp=1671093560~hmac=8f9926c4c7dfbe6fdf397e1a1d13e418", "Learn about the latest trends and topics on beauty, welness and more"))
    return services
}


