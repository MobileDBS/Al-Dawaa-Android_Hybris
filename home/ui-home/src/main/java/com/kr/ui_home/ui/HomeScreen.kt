package com.kr.ui_home.ui

import androidx.compose.foundation.layout.*
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import android.view.Gravity
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.SnackbarHostComponent
import com.kr.components.textFieldComponent.TextFieldComponent
import com.kr.components.ui.theme.InputHint
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.SecondaryColor
import com.kr.services_domain.model.Services
import com.kr.ui_home.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val snackbarHostState = SnackbarHostState()
    val coroutinescope = rememberCoroutineScope()
    val scroll = rememberScrollState(0)

            Column(modifier = Modifier.verticalScroll(scroll)) {//modifier = Modifier.padding(16.dp)
                val isShowing = remember { mutableStateOf(false) }
                //start arbay
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PrimaryColor)
                        .wrapContentHeight()
                ) {
                    Column() {
                        TxtField(context)
                        TextButton(
                            onClick = {
                                isShowing.value = true
                                coroutinescope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as a",
                                        actionLabel = "HIDE",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                                /*         Toast
                            .makeText(context, "Go To logi", Toast.LENGTH_SHORT)
                            .show()*/
                            }, modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                        )
                        {
                            Text(
                                text = "Login to check Arbahi points",
                                color = SecondaryColor,
                                fontSize = 15.sp
                            )
                            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                "",
                                modifier = Modifier.size(ButtonDefaults.IconSize),
                                tint = SecondaryColor
                            )
                        }
                        /*      SampleSnackbar (isShowing= isShowing.value,
                              onHideSnackbar = {isShowing.value = false})*/
                        SnackbarHostComponent(snackbarHostState)
                    }
                }
                //end arbahi section
                // start product list

                // Text(text = "Home Screen", color = PrimaryColor)


                HomeProductList(navController)

                //end product list


                // start services
                Column(modifier = Modifier.padding(16.dp)) {


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Services", color = PrimaryColor,
                            textAlign = TextAlign.Start
                        )

                        Text(text = "See All", color = PrimaryColor, textAlign = TextAlign.End)

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

            // end services

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
        TextFieldComponent(
            _value = inputvalue.value,
            _onValueChange = {newValue ->
                inputvalue.value = newValue},
            _placeholder = {  Text(
                text = stringResource(id = R.string.enteryourpass),
                color = InputHint
            ) },
            _leadingIcon = {    Icon(
                Icons.Filled.Search,"",
                tint = Color.LightGray
            ) },
            _trailingIcon = {
                Icon(
                    Icons.Filled.Info, "",
                    tint = Color.LightGray, modifier = Modifier.clickable {
                        Toast
                            .makeText(context, "Open Scanner...", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            },
            _textStyle = TextStyle(
                color = PrimaryColor,
                fontFamily = FontFamily.SansSerif
            ),
            _colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White)
        )
/*        OutlinedTextField(
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
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White),
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
                    Icons.Filled.Info, "",
                    tint = Color.LightGray, modifier = Modifier.clickable {
                        Toast
                            .makeText(context, "Open Scanner...", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
                 })*/
    }

}
