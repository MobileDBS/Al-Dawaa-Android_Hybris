@file:OptIn(ExperimentalCoroutinesApi::class)

package com.kr.aldawaa.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kr.ui_login.ui.EntryScreen
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi


@DelicateCoroutinesApi
@ExperimentalMaterialApi
@Preview
@Composable
fun Navigatpage(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "Login_page",
        builder = {
            composable("Login_page", content = { EntryScreen(navController = navController) })
//            composable("Forget_Password", content = { ForgetPassword(navController = navController)  })
//            composable("Forget_Password_Otp", content = { ForgetPasswordOtp(navController = navController)  })
//            composable("Forget_Change_Password", content = { ForgetChangePassword(navController = navController)  })
//            composable("Forget_Success", content = { ForgetSuccess(navController = navController)  })
//


        }
    )
}
