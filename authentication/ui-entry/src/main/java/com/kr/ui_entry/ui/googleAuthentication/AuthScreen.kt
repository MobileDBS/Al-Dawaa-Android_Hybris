package com.kr.ui_entry.ui.googleAuthentication

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun AuthScreen(
    authViewModel: AuthViewModel,
   navController:NavController,

) {
    var token by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()
    var text by remember { mutableStateOf<String?>(null) }
    val user by remember(authViewModel) { authViewModel.user }.collectAsState()
    val signInRequestCode = 1
    token= Googletokenid


    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResultContract()) { task ->

            try {
                val account = task?.getResult(ApiException::class.java)
                if (account == null) {
                    text = "Google sign in failed"
                } else {

                    coroutineScope.launch {
                        authViewModel.signIn(
                            email = account.email!!,
                            displayName = account.displayName!!,
                        )
                        token = account.idToken.toString()
                        val id = account.id!!
                        Log.e("Google id : ", id)
                        Log.e("Google id : ", task.result.idToken.toString())

                        val familyName = account.familyName!!
                        Log.e("Google familyName : ", familyName.toString())
                        val givenName = account.givenName!!
                        Log.e("Google givenName : ", givenName.toString())
                        val grantedScopes = account.grantedScopes
                        Log.e("Google grantedScopes : ", grantedScopes.toString())
                        val accountt = account.account!!
                        Log.e("Google accountt : ", accountt.toString())
                        val idToken = account.idToken.toString()
                        Log.e("Google idToken : ", idToken)
                        val isExpired = account.isExpired
                        Log.e("Google isExpired : ", isExpired.toString())
                        val photoUrl = account.photoUrl.toString()
                        Log.e("Google photoUrl : ", photoUrl)
                        val requestedScopes = account.requestedScopes
                        Log.e("Google-requested: ", requestedScopes.toString())
                        val serverAuthCode = account.serverAuthCode.toString()
                        Log.e("Google serverAuthCo : ", serverAuthCode)


                    }
                }

            } catch (e: ApiException) {
                Log.e("Google Error : ", e.toString())
            }
        }

    IconButton(
        onClick = {
            if (token.toString().isEmpty()) {
                authResultLauncher.launch(signInRequestCode)

            } else {

                navController.navigate("MainUi")
            }


        }, modifier = Modifier
            .background(Color.Unspecified).wrapContentSize(),

    ) {
        //   Icon(painter = painterResource(id = R.drawable.ic_facebook)  , contentDescription ="facebook icon" )

    }
}

var Googletokenid = ""