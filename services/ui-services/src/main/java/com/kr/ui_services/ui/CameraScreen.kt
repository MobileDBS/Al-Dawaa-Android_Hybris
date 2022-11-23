@file:OptIn(ExperimentalPermissionsApi::class, ExperimentalCoroutinesApi::class)

package com.kr.ui_services.ui

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.kr.components.ui.theme.PrimaryColor
import com.kr.ui_services.R
import com.kr.ui_services.ui.componant.camera.CameraCapture
import com.kr.ui_services.ui.componant.gallery.GallerySelect
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Composable
fun CameraScreen(navController: NavController) {
    Scaffold() {

        Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            var imageUri by remember { mutableStateOf(EMPTY_IMAGE_URI) }


            Surface(color = MaterialTheme.colors.background,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(425.dp),
                shape = RoundedCornerShape(24.dp)) {
                if (imageUri != EMPTY_IMAGE_URI) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = rememberImagePainter(imageUri),
                            contentDescription = "Captured image"
                        )
                        IconButton(
                            modifier = Modifier.align(Alignment.TopEnd).padding(end = 10.dp),
                            onClick = {
                                imageUri = EMPTY_IMAGE_URI
                            }
                        ) {
                           Icon(imageVector = Icons.Filled.Close, contentDescription ="close camera" )
                        }
                    }
                } else {
                    var showGallerySelect by remember { mutableStateOf(false) }
                    if (showGallerySelect) {
                        GallerySelect(
                            modifier = Modifier.fillMaxSize(),
                            onImageUri = { uri ->
                                showGallerySelect = false
                                imageUri = uri
                            }
                        )
                    } else {
                        Box(modifier = Modifier.fillMaxSize()) {
                            CameraCapture(
                                modifier = Modifier.fillMaxSize(),
                                onImageFile = { file ->
                                    imageUri = file.toUri()
                                }
                            )
                            /*Button(
                                modifier = Modifier
                                    .align(Alignment.TopCenter)
                                    .padding(4.dp),
                                onClick = {
                                    showGallerySelect = true
                                }
                            ) {
                                Text("Select from Gallery")
                            }*/
                        }
                    }
                }


            }

            Row() {
                Spacer(modifier = Modifier.padding(20.dp))
            }

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(53.dp)
                    .clip(shape = RoundedCornerShape(24.dp)),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent
                ),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(2.dp, PrimaryColor),

                onClick = {
                    //  navController.navigate("MainUi")


                },


                ) {
                Text(
                    text = "Apply",
                    fontSize = 20.sp,
                    color = PrimaryColor,
                )


            }
        }
    }
}
val EMPTY_IMAGE_URI: Uri = Uri.parse("file://dev/null")
