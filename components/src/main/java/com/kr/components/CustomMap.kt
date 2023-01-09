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
fun CustomMap(locationList: ArrayList<LatLng>) {
   val icon=R.drawable.location
    Column() {

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(30.026348, 31.482875), 4f)
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
            GoogleMarkers(icon,locationList)
        }
    }
}

@Composable
fun GoogleMarkers(@DrawableRes iconResourceId:Int,locationList: List<LatLng>) {
    val icon=bitmapDescriptorFromVactor(LocalContext.current,iconResourceId)
    locationList.forEach {
        Marker(
            state = rememberMarkerState(position = it),
            title = "Marker2",
            icon = icon
        )
    }
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


fun getLocationLest():ArrayList<LatLng>{
    var list:ArrayList<LatLng> = arrayListOf()
    list.add(LatLng(30.026348, 31.482875))
    list.add(LatLng(29.026348, 30.482875))
    list.add(LatLng(25.026348, 29.482875))
    list.add(LatLng(20.026348, 25.482875))
    list.add(LatLng(24.026348, 21.482875))
    return list
}