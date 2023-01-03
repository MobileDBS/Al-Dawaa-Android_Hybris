package com.kr.components

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*

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
   val icon=R.drawable.ic_close
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
            mutableStateOf(MapProperties(mapType = MapType.NORMAL, isMyLocationEnabled = true))
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
            GoogleMarkers(icon)
        }
    }
}

@Composable
fun GoogleMarkers(@DrawableRes iconResourceId:Int) {
    val icon=bitmapDescriptorFromVactor(LocalContext.current,iconResourceId)
    Marker(
        state = rememberMarkerState(position = LatLng(44.811058, 20.4627586)),
        title = "Marker2",
        icon = icon
    )
    Marker(
        state = rememberMarkerState(position = LatLng(44.810058, 20.4627586)),
        title = "Marker3",
        icon = icon
    )
    Marker(
        state = rememberMarkerState(position = LatLng(44.809058, 20.4627586)),
        title = "Marker4",
        icon = icon
    )
    Marker(
        state = rememberMarkerState(position = LatLng(44.809058, 20.4617586)),
        title = "Marker5",
        icon = icon
    )
}

fun bitmapDescriptorFromVactor(context: Context, vectorResourceId:Int): BitmapDescriptor? {
     val drawable= ContextCompat.getDrawable(context,vectorResourceId)
    drawable?.setBounds(0,0,drawable.intrinsicWidth,drawable.intrinsicHeight)
    val bitmap= Bitmap.createBitmap(drawable!!.intrinsicWidth,drawable!!.intrinsicHeight,Bitmap.Config.ARGB_8888)
    //Draw it into Bitmap
    val canves=android.graphics.Canvas(bitmap)
    drawable.draw(canves)
    return BitmapDescriptorFactory.fromBitmap(bitmap)
}


