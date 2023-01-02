package com.kr.components

import android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationRequest
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionsRequired
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.kr.components.StartPermissionSetting

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CustomPermission(permissions : List<String> ,  permissionContent: (String) -> Unit) {
    val context = LocalContext.current.applicationContext
    val multiplePermissionState = rememberMultiplePermissionsState(permissions)
    LaunchedEffect(Unit) {
        multiplePermissionState.launchMultiplePermissionRequest()
    }
    PermissionsRequired(
        multiplePermissionsState = multiplePermissionState,
        permissionsNotGrantedContent = {
            permissionContent("not granted")
            Log.v("permission", "not granted")
        },
        permissionsNotAvailableContent = {
            permissionContent("not available")
            Log.v("permission", "not available")
            StartPermissionSetting(context.resources.getString(R.string.access_location_msg))

        }
    ) {


    }
}