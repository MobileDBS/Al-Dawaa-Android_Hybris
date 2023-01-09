@file:OptIn(ExperimentalPermissionsApi::class, ExperimentalCoroutinesApi::class)

package com.kr.ui_services.ui

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
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
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.kr.components.CustomOutlinedButton
import com.kr.components.ui.theme.BTNSTATE
import com.kr.components.ui.theme.PrimaryColor

import com.kr.ui_services.ui.componant.camera.CameraCapture
import com.kr.ui_services.ui.componant.gallery.GallerySelect
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraScreen(navController: NavController, showGallery :Boolean) {

    var showGallerySelect by remember { mutableStateOf(false) }

    Scaffold() {

        Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            var imageUri by remember { mutableStateOf(EMPTY_IMAGE_URI) }

            Log.d("select gallery ", "select value $showGallery")

            Surface(color = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(425.dp),
                shape = RoundedCornerShape(24.dp)) {
                if (imageUri != EMPTY_IMAGE_URI) {

                    Log.d("select gallery ", "photo url $imageUri")

                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = rememberAsyncImagePainter(imageUri),
                            contentDescription = "Captured image"
                        )
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(end = 10.dp),
                            onClick = {
                                imageUri = EMPTY_IMAGE_URI
                                showGallerySelect = false

                            }
                        ) {
                           Icon(imageVector = Icons.Filled.Close, contentDescription ="close camera" )
                        }
                    }
                } else {
                    showGallerySelect= showGallery

                    if (showGallerySelect) {
                        GallerySelect(
                            modifier = Modifier.fillMaxSize(),
                            onImageUri = { uri ->
                                showGallerySelect = false
                                imageUri = uri
                                Log.d("select gallery ", "photo url $imageUri")

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

                        }
                    }
                }


            }

            Row() {
                Spacer(modifier = Modifier.padding(20.dp))

               /* Button(
                    modifier = Modifier
                      //  .align(Alignment.TopCenter)
                        .padding(4.dp),
                    onClick = {
                        showGallerySelect = true
                    }
                ) {
                    Text("Select from Gallery")
                }*/
            }
            CustomOutlinedButton(onClick = {

            }, statue = BTNSTATE.ACTIVE,
            contenttext = "Apply")


        }
    }
}
val EMPTY_IMAGE_URI: Uri = Uri.parse("file://dev/null")
