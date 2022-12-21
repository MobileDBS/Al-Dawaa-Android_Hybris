package com.kr.components

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CustomDialog(
    description: String ,
    navigateToSettingsScreen: () -> Unit,
    content: @Composable() () -> Unit) {

    val context = LocalContext.current.applicationContext
    fun <T> stateSaver() = Saver<MutableState<T>, Any>(
        save = { state -> state.value ?: "null" },
        restore = { value ->
            @Suppress("UNCHECKED_CAST")
            (mutableStateOf((if (value == "null") null else value) as T))
        }
    )

    // Track if the user doesn't want to see the rationale any more.
    var doNotShowRationale by rememberSaveable(saver = stateSaver()) { mutableStateOf(false) }

    // Permission state
    val permissionState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    )




    when {
        permissionState.allPermissionsGranted -> {
            content()
        }
        // If the user denied the permission but a rationale should be shown, or the user sees
        // the permission for the first time, explain why the feature is needed by the app and allow
        // the user to be presented with the permission again or to not see the rationale any more.
        permissionState.shouldShowRationale ||
                !permissionState.permissionRequested -> {
            if (doNotShowRationale) {
                Text("Feature not available")
            } else {
                Column {
                    Text("Need to detect current location. Please grant the permission.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Button(onClick = { permissionState.launchMultiplePermissionRequest() }) {
                            Text("Request permission")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = { doNotShowRationale = true }) {
                            Text("Don't show rationale again")
                        }
                    }
                }
            }
        }
        // If the criteria above hasn't been met, the user denied the permission. Let's present
        // the user with a FAQ in case they want to know more and send them to the Settings screen
        // to enable it the future there if they want to.
        else -> {
            Column {
                Text(
                    "Request location permission denied. " +
                            "Need current location to show nearby places. " +
                            "Please grant access on the Settings screen."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = navigateToSettingsScreen) {
                    Text("Open Settings")
                }
            }
        }
    }



    Dialog(
        onDismissRequest = {
        }
    ) {

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
                        onClick = {  },
                        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp, start = 24.dp, end = 24.dp).weight(0.5f),

                    ){
                        Text(text = "Settings", color = LightBlue)
                    }
                    Text(
                        modifier = Modifier
                            .padding(top = 15.dp, bottom = 15.dp, start = 24.dp, end = 24.dp)
                            .weight(0.5f),
                        textAlign = TextAlign.Center,
                        text = "Settings",
                        style = TextStyle(
                            fontSize = 16.sp
                        ),
                        color =LightBlue,


                        )

                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 15.dp, bottom = 15.dp, start = 24.dp, end = 24.dp)
                            .weight(0.5f),
                        textAlign = TextAlign.Center,
                        text = "Ok",
                        style = TextStyle(fontSize = 16.sp),
                        color = LightBlue,
                    )

                }
            }

        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StartPermissionSetting() {
    val context = LocalContext.current

    CustomDialog(context.resources.getString(R.string.access_location_msg),
        navigateToSettingsScreen = {
        context.startActivity(
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", context.packageName, null)
            )
        )
    }) {
        Text("Location Permission Accessible")
    }
}