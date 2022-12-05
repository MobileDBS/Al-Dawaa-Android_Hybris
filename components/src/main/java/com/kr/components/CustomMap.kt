package com.kr.components

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.location.Location
import android.location.LocationRequest
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*
import java.util.jar.Manifest

/*class LocationClass{
    var currentLocation: Location? = null
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun GetLastLocation() {
        // var x:Interface=InterfaceClass()

        *//*   val LocalInterface = staticCompositionLocalOf<Interface> { error("Not provided") }
           var inner: Interface? =null

           CompositionLocalProvider(
               LocalInterface provides inter
           ) {
                inner = LocalInterface.current // Call at any desired level
           }*//*

        val multiplePermissionState = rememberMultiplePermissionsState(
            permissions = listOf(
                ACCESS_COARSE_LOCATION,
                ACCESS_FINE_LOCATION
            )
        )
        LaunchedEffect(Unit) {
            multiplePermissionState.launchMultiplePermissionRequest()
        }
        PermissionsRequired(
            multiplePermissionsState = multiplePermissionState,
            permissionsNotGrantedContent = { *//* ... *//* },
            permissionsNotAvailableContent = { *//* ... *//* }
        ) {

            lateinit var fusedLocationClient: FusedLocationProviderClient
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(LocalContext.current)

            fusedLocationClient.getCurrentLocation(LocationRequest.QUALITY_HIGH_ACCURACY, null)
                .addOnSuccessListener { location: Location? ->
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        currentLocation = location

                        //    inner!!.findLocation(location)

                        Log.v("location", currentLocation!!.latitude.toString())

                    } else
                        currentLocation == null
                }

        }

        // if (currentLocation!=null)
        //   CustomMap(locatio = currentLocation)
        //return currentLocation!!

    }
}*/


//@OptIn(ExperimentalPermissionsApi::class)
class Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Toast.makeText(this, "This is Activity", Toast.LENGTH_SHORT).show()
            //CustomMap()
        }
    }
}

@Composable
fun CustomMap() {
    Column() {

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(30.026348, 31.482875), 17f)
        }
        var uiSettings by remember {
            mutableStateOf(
                MapUiSettings(
                    compassEnabled = true,
                    zoomControlsEnabled = true
                )
            )
        }
        var properties by remember {
            mutableStateOf(MapProperties(mapType = MapType.NORMAL))
        }
        GoogleMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.weight(1f),
            properties = properties,
            uiSettings = uiSettings
        ) {
            /*   Marker(
                   state = rememberMarkerState(position = LatLng(currentLocation!!.latitude, currentLocation!!.longitude)),
                   title = "Marker1",
                   icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
               )*/
            GoogleMarkers()
        }
    }
}

@Composable
fun GoogleMarkers() {
    Marker(
        state = rememberMarkerState(position = LatLng(44.811058, 20.4627586)),
        title = "Marker2",
        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
    )
    Marker(
        state = rememberMarkerState(position = LatLng(44.810058, 20.4627586)),
        title = "Marker3",
        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
    )
    Marker(
        state = rememberMarkerState(position = LatLng(44.809058, 20.4627586)),
        title = "Marker4",
    )
    Marker(
        state = rememberMarkerState(position = LatLng(44.809058, 20.4617586)),
        title = "Marker5",
        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
    )
}


