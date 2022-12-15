package com.kr.ui_services.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.kr.components.ui.theme.PrimaryColor
import com.kr.services_domain.model.Services
import com.kr.ui_services.R


@Composable
fun ServicesScreen(navController: NavController,modifier: Modifier = Modifier) {
        LazyColumn(
            state = rememberLazyListState(),
            userScrollEnabled = true,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().fillMaxHeight().paint(
                    painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds
        ),
            content = {


                items(getServicesData()) { item ->
                    ServicesItem(item) {

                    }
                }

            }
        )
}

private fun getServicesData(): List<Services> {
    val services: ArrayList<Services> = arrayListOf()
    services.add(
        Services(1 , "Booking", "https://thumbs.dreamstime.com/b/pills-medicine-background-25754120.jpg" ,
            "https://tse1.mm.bing.net/th?id=OIP.hQs33uf3Ag3u7pQvgBwSnwHaHW&pid=Api&P=0" , "Get appointments face-to-face or through video calls.")
    )
    services.add(Services(2 , "Health services", "https://prnewswire2-a.akamaihd.net/p/1893751/sp/189375100/thumbnail/entry_id/0_x9ajkzs1/def_height/2700/def_width/2700/version/100012/type/1" ,
        "https://tse1.mm.bing.net/th?id=OIP.hQs33uf3Ag3u7pQvgBwSnwHaHW&pid=Api&P=0" , "Make your life easier with many of the services we offer."))
    services.add(
        Services(3 , "Delivery services", "https://www.arbd.com/wp-content/uploads/2015/07/AdobeStock_130050329.jpeg" ,
            "https://tse1.mm.bing.net/th?id=OIP.hQs33uf3Ag3u7pQvgBwSnwHaHW&pid=Api&P=0", "Track your order, see delivery details and order&receive, FAQ")
    )
    services.add(
        Services(4 , "Blog", "https://media.istockphoto.com/photos/prescription-drugs-picture-id183369961?k=6&m=183369961&s=612x612&w=0&h=uYQDTxgWxnhsAnjJ-KIIQtEd-ljQwit5OuIcnFtGU3Y=" ,
            "https://tse1.mm.bing.net/th?id=OIP.hQs33uf3Ag3u7pQvgBwSnwHaHW&pid=Api&P=0", "Learn about the latest trends and topics on beauty, welness and more")
    )
    return services
}



