package com.kr.aldawaa

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


class LocationClass(interfaceListener: Interface){
    var currentLocation: Location? = null
    private  var interfaceListener: Interface
init {
this.interfaceListener=interfaceListener
}
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun GetLastLocation() {
        val context = LocalContext.current.applicationContext
        val multiplePermissionState = rememberMultiplePermissionsState(
            permissions = listOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
        LaunchedEffect(Unit) {
            multiplePermissionState.launchMultiplePermissionRequest()
        }
        PermissionsRequired(
            multiplePermissionsState = multiplePermissionState,
            permissionsNotGrantedContent = {
                Log.v("location_permission" , "not granted")
            },
            permissionsNotAvailableContent = {
                Log.v("location_permission" , "not available")

            }
        ) {

            lateinit var fusedLocationClient: FusedLocationProviderClient
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(LocalContext.current)

            fusedLocationClient.getCurrentLocation(LocationRequest.QUALITY_HIGH_ACCURACY, null)
                .addOnSuccessListener { location: Location? ->
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        currentLocation = location
                         interfaceListener.findLocation(location)
                        Log.v("location", currentLocation!!.latitude.toString())

                    } else
                        currentLocation == null
                }

        }

    }
    interface Interface
    {
        fun  findLocation(location: Location)
    }

}