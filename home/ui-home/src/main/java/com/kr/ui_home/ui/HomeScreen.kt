package com.kr.ui_home.ui

import InputHint
import PrimaryColor
import SecondaryColor
import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import android.view.Gravity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
import com.kr.services_domain.model.Services
import com.kr.ui_home.R


@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.TopCenter){
       Column() {
           Box(modifier = Modifier
               .fillMaxWidth()
               .background(PrimaryColor)
               .wrapContentHeight()) {
               Column() {
                   TxtField(context)
                   TextButton(onClick = {
                       Toast
                           .makeText(context, "Go To logi", Toast.LENGTH_SHORT)
                           .show() }, modifier = Modifier
                       .fillMaxWidth()
                       .wrapContentHeight())
                   {
                       Text(text = "Login to check Arbahi points", color= SecondaryColor, fontSize = 15.sp)
                       Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                       Icon(imageVector = Icons.Filled.Favorite,
                           "", modifier = Modifier.size(ButtonDefaults.IconSize), tint = SecondaryColor)
                   }

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
                        navController.navigate("service")
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
        Services(3 , "Delivery services", "https://thumbs.dreamstime.com/b/pills-medicine-background-25754120.jpg" , "https://cdn-icons.flaticon.com/svg/3917/3917688.svg?token=exp=1671093560~hmac=9caa1f2eb10a47f956753ab3401160fa", "Track your order, see delivery details and order&receive, FAQ"))
    services.add(
        Services(4 , "Blog", "https://prnewswire2-a.akamaihd.net/p/1893751/sp/189375100/thumbnail/entry_id/0_x9ajkzs1/def_height/2700/def_width/2700/version/100012/type/1" , "https://cdn-icons.flaticon.com/svg/3917/3917058.svg?token=exp=1671093560~hmac=8f9926c4c7dfbe6fdf397e1a1d13e418", "Learn about the latest trends and topics on beauty, welness and more"))
    return services
               }

           }
           OutlinedButton(onClick = { navController.navigate("Product_List") }) {
               Text("Open ProductList")
           }

       }
    }
}
@Composable
fun TxtField(context:Context) {
    // we are creating a variable for
    // getting a value of our text field.
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    Column(
        // we are using column to align our
        // imageview to center of the screen.
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),

        // below line is used for specifying
        // vertical arrangement.
        //verticalArrangement = Arrangement.Center,

        // below line is used for specifying
        // horizontal arrangement.
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        OutlinedTextField(
            // below line is used to get
            // value of text field,
            value = inputvalue.value,
            onValueChange = { value ->
                inputvalue.value = value
            },
            // below line is used to add placeholder
            // for our text field.
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enteryourpass),
                    color = InputHint
                )
            },
            // modifier is use to add padding
            // to our text field.
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            // keyboard options is used to modify
            // the keyboard for text field.
            keyboardOptions = KeyboardOptions(
                // below line is use for capitalization
                // inside our text field.
                capitalization = KeyboardCapitalization.None,

                // below line is to enable auto
                // correct in our keyboard.
                autoCorrect = true,

                // below line is used to specify our
                // type of keyboard such as text, number, phone.
                keyboardType = KeyboardType.Text,
            ),
            // below line is use to specify
            // styling for our text field value.
            textStyle = TextStyle(
                color = PrimaryColor,
                // below line is used to add font
                // size for our text field


                // below line is use to change font family.
                fontFamily = FontFamily.SansSerif
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
            // below line is use to give
            // max lines for our text field.
            maxLines = 2,
            shape = RoundedCornerShape(35.dp),
//            // active color is use to change
//            // color when text field is focused.
//            activeColor = colorResource(id = R.color.cardview_dark_background),
//
//            // single line boolean is use to avoid
//            // textfield entering in multiple lines.
           singleLine = true,
            leadingIcon = {
                // In this method we are specifying ,our leading icon and its color.
                Icon(
                    Icons.Filled.Search,"",
                   tint = Color.LightGray
                )
            },
            trailingIcon = {
                // trailing icons is use to add ,icon to the end of text field.
                     Icon(
                    Icons.Filled.Info,"",
                    tint = Color.LightGray, modifier = Modifier.clickable {
                             Toast
                                 .makeText(context, "Open Scanner...", Toast.LENGTH_SHORT)
                                 .show()
                         }
                )
            }


