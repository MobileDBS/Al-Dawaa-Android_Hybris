package com.kr.ui_entry.ui.facebookAuthentication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.facebook.AccessToken
import com.facebook.GraphRequest


@Composable
fun FacebookLogin(navController: NavController) {
    val context = LocalContext.current


    val facebookSignRequest =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val data = result.data?.getStringExtra(FBLoginActivity.EXTRA_DATA_FB)
                val accessToken: AccessToken? = AccessToken.getCurrentAccessToken()
                //do something with data
                val datax = result.data?.extras.toString()
                val dataxe = result.data?.getStringExtra(FBLoginActivity.EXTRA_DATA_FB)
                Log.d("facebook", "data is ${result.toString()}")
                Log.d("facebook", "data is ${datax.toString()}")
                Log.d("facebook", "data is ${dataxe.toString()}")


                val request = GraphRequest.newMeRequest(
                    accessToken,
                    callback = GraphRequest.GraphJSONObjectCallback { obj, response ->
                        val id: String = obj?.getString("id").toString()
                        val name: String = obj?.getString("name").toString()
                        val email: String = obj?.getString("email").toString()
                        // val pictureUri: String = obj?.getString("pictureUri").toString()
                        val picture: String = obj?.getString("picture").toString()

                        Log.e("facebookname1 : ", id)
                        Log.e("facebooklink1 : ", name)
                        Log.e("facebookmail1 : ", email)
                        Log.e("facebookpicture1 : ", picture)
                    })

                val parameters = Bundle()
                parameters.putString("fields", "id,name,email,picture")

                request.parameters = parameters
                request.executeAsync()
                Log.e("facebookparam : ", parameters.toString())
                Log.e("facebook : ", accessToken.toString())

                Log.e("facebook : ", accessToken?.expires.toString())

                Log.e("facebook : ", accessToken?.userId.toString())




            }
        }

    IconButton(onClick = {
        if (AccessToken.getCurrentAccessToken() == null) {
            facebookSignRequest.launch(FBLoginActivity.getInstance(context))

        }else{
            navController.navigate("MainUi")
        }


    }, modifier = Modifier
        .background(Color.Unspecified)
        .fillMaxSize()) {
        //   Icon(painter = painterResource(id = R.drawable.ic_facebook)  , contentDescription ="facebook icon" )

    }
}
