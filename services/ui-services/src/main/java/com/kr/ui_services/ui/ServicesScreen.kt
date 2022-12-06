@file:OptIn(ExperimentalPermissionsApi::class)

package com.kr.ui_services.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.kr.ui_services.R


@Composable
fun ServicesScreen(navController: NavController,modifier: Modifier = Modifier) {
    var showGallerySelect by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf(EMPTY_IMAGE_URI) }
    var context = LocalContext.current



    Scaffold( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Column( horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize()
                
                ) {

            Spacer(modifier = modifier.padding(60.dp))

                    Surface(modifier = modifier
                        .fillMaxWidth(0.9f)
                        .height(100.dp), elevation = 2.dp,
                    shape = RoundedCornerShape(28.dp)) {


                        
                        Row(horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.fillMaxWidth()) {

                                IconButton(onClick = {
                                    showGallerySelect = true
                                    navController.navigate("Camera_Screen?showvalu=$showGallerySelect")


                                },
                                    modifier = modifier.weight(5f)) {
                                    Column( horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                       ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.upload),

                                        contentDescription = "upload photo",
                                        modifier = modifier
                                            .height(20.dp)
                                            .width(23.dp)
                                    )
                                    Text("Upload")

                                }

                            }

                            Text(text = "Or" ,modifier = modifier.weight(1f))



                                IconButton(onClick = {
                                    showGallerySelect= false
                                    navController.navigate("Camera_Screen?showvalu=$showGallerySelect")

                                },
                                    modifier = Modifier.weight(5f)) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                        ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.cameracap),

                                        contentDescription = "Capture photo ",
                                        modifier = Modifier
                                            .height(20.dp)
                                            .width(16.dp)

                                    )

                                    Text("Capture")

                                }

                            }
                            
                        }
                        
                    }
            

            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                Text(text = "Services Screen")
            }
        }
    }

}


