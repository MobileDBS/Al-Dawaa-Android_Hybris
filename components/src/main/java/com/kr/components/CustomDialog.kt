package com.kr.components

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.kr.components.ui.theme.LightBlue

@Composable
fun CustomDialog(
    description: String,
    navigateToSettingsScreen: () -> Unit,
) {

    val context = LocalContext.current.applicationContext
    val dialogState: MutableState<Boolean> = remember {
        mutableStateOf(true)
    }
    if (dialogState.value) {
        Dialog(
            onDismissRequest = { dialogState.value = false },
            content = {
                DialogContent(description = description , dialogState  = dialogState, navigateToSettingsScreen = navigateToSettingsScreen)
            }
        )
    }
    else {
        Toast.makeText(context, "Dialog Closed", Toast.LENGTH_SHORT).show()
    }

}

    @Composable
    fun DialogContent (description: String ,
                       dialogState : MutableState<Boolean>,
                               navigateToSettingsScreen: () -> Unit,
    ){

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(size = 20.dp),
        ) {

            Column(
                modifier = Modifier
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp),
                    textAlign = TextAlign.Center,
                    text = description,
                    style = TextStyle(
                        color = Color.Black.copy(alpha = 0.95f),
                        fontSize = 16.sp,
                        lineHeight = 22.sp
                    )
                )

                Divider(color = Color.LightGray, thickness = 1.dp)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 5.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {

                    // Cancel button

                    Button(
                        onClick = navigateToSettingsScreen,
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .weight(0.5f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified)

                    ) {
                        Text(
                            text = "Settings",
                            color = LightBlue,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    Button(
                        onClick = {dialogState.value = false},
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .weight(0.5f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified)

                    ) {
                        Text(
                            text = "Cancel",
                            color = LightBlue,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                }
            }

        }
    }

@Composable
fun StartPermissionSetting(description: String,) {
    val context = LocalContext.current
    CustomDialog(
        description = description,
        navigateToSettingsScreen = {
            context.startActivity(
                Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", context.packageName, null)
                )
            )
        })

}