@file:Suppress("DEPRECATION")
@file:OptIn(ExperimentalFoundationApi::class, DelicateCoroutinesApi::class)

package com.kr.ui_entry.ui


import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.ui_entry.R
import PrimaryColor
import SecondaryColor
import com.kr.components.ui.theme.ShapeTabButtons
import com.kr.components.ui.theme.Shapes
import com.kr.ui_login.ui.LoginScreen

import kotlinx.coroutines.*
import ui_register.ui.SignupScreen


@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@SuppressLint("ResourceType", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EntryScreen(navController: NavController) {

    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val languages = listOf("English", "العربية")

    var chosenlanguage by rememberSaveable { mutableStateOf("English") }
    val errorMessage = "name format is invalid"

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), scaffoldState = scaffoldState
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(color = PrimaryColor)
                .verticalScroll(rememberScrollState())

        ) {


            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(80.dp)
                    .background(color = PrimaryColor),
                painter = painterResource(R.drawable.ic_eye_hide),
                contentDescription = "login image",
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = stringResource(id = R.string.wellcometoaldawaa),
                fontSize = 25.sp,
                color = White,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.padding(6.dp))


        Box() {


            OutlinedButton(
                colors = ButtonDefaults.buttonColors(backgroundColor = Transparent),
                onClick = { expanded = !expanded }, modifier = Modifier.background(
                    color = Transparent
                )
            ) {
                Text(chosenlanguage, color = White)
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    tint = White,
                    contentDescription = null,

                    )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(color = Transparent),


                ) {
                Color.DarkGray
                languages.forEach { label ->
                    DropdownMenuItem(modifier = Modifier.background(Color.Transparent), onClick = {
                        // expanded = true

                        when (label) {
                            "English" -> {
                                chosenlanguage = label
                               // setLanguage(context, Locale("en"))
                                (context as? Activity)?.recreate()
                                chosenlanguage = label

                            }
                            "العربية" -> {
                                chosenlanguage = label
                                //setLanguage(context, Locale("ar"))
                                (context as? Activity)?.recreate()

                            }
                        }
                    }) {
                        Text(text = label)
                    }
                }
            }
        }

            Spacer(modifier = Modifier.padding(10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,

                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .clip(
                        shape = Shapes.large.copy(
                            bottomStart = ZeroCornerSize,
                            bottomEnd = ZeroCornerSize
                        )
                    )
                    // .background(color = White)
                    .paint(
                        painterResource(id = R.drawable.background),
                        contentScale = ContentScale.FillBounds
                    )


            ) {
                Spacer(modifier = Modifier.padding(15.dp))


                var selectedIndex by remember { mutableStateOf(0) }

                val list = listOf(
                    stringResource(id = R.string.signintap),
                    stringResource(id = R.string.signuptap)
                )

                TabRow(selectedTabIndex = selectedIndex,
                    backgroundColor = Transparent,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .clip(RoundedCornerShape(50))
                        ,
                    divider = { TabRowDefaults.Divider(color = Transparent) },
                    indicator = { tabPositions: List<TabPosition> ->

                        //   Box {          colors.primaryVariant.red              }
                    }
                ) {
                    list.forEachIndexed { index, text ->
                        val selected = selectedIndex == index
                        Tab(
                            modifier = if (selected) Modifier
                                .clip(shape = ShapeTabButtons.large)
                                .background(
                                    SecondaryColor,
                                )
                            else Modifier
                                .clip(shape = ShapeTabButtons.large)
                                .background(
                                    Color.Transparent
                                ),
                            selected = selected,
                            onClick = { selectedIndex = index },
                            text = { Text(text = text, color = PrimaryColor) }
                        )

                    }


                }

                when (selectedIndex) {
                    0 -> {
                        LoginScreen(navController = navController)
                    }

                    1 -> {
                         SignupScreen(navController = navController)

                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.background(Transparent)
                ) {



                        Text(
                        text = stringResource(id = R.string.orsigninwith),
                        fontSize = 15.sp,
                        color = PrimaryColor,
                    )
                    Spacer(modifier = Modifier.padding(15.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))) {
                           // AuthScreen(authViewModel)
                        }


                        Spacer(modifier = Modifier.padding(4.dp))

                        //facebook
                        Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))) {
                        }


                        Spacer(modifier = Modifier.padding(4.dp))
                        //Google

                    }

                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = stringResource(id = R.string.continueasaguest),
                    color = PrimaryColor,
                    modifier = Modifier.clickable {
                        // navController.navigate("")
                        Toast.makeText(context, "Wellcome to Home ", Toast.LENGTH_SHORT).show()


                    })
                Spacer(modifier = Modifier.padding(10.dp))


            }

        }

    }
}
