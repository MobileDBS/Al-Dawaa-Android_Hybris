@file:OptIn(ExperimentalCoroutinesApi::class, ExperimentalCoroutinesApi::class)

package com.kr.aldawaa.ui

import android.app.Activity
import android.content.Intent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kr.productlist.ProductListScreen
import com.kr.ui_entry.ui.EntryScreen
import com.kr.ui_otp.ui.OtpScreen
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ui_forgetpassword.ui.ForgetPasswordScreen
import ui_forgetpassword.ui.ForgetSuccess
import ui_forgetpassword.ui.NewPasswordScreen


@ExperimentalMaterial3Api
@DelicateCoroutinesApi
@Composable
fun NavigationController() {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login_page",
        builder = {

            composable("Login_page", content = { EntryScreen(navController = navController) {

                context.startActivity(Intent(context, MainActivity::class.java))
                val activity = context as Activity
                activity.finish()
            }
            })
            composable(
                "Forget_Password",
                content = { ForgetPasswordScreen(navController = navController) })
            composable(
                "Forget_Password_Otp",
                content = { OtpScreen(navController = navController) })
            composable(
                "Forget_Change_Password",
                content = { NewPasswordScreen(navController = navController) })
            composable("Forget_Success", content = { ForgetSuccess(navController = navController) })

            composable("MainUi", content = { MainScreen() })

            composable("Product_List", content = { ProductListScreen(navController=navController) {} })

            /* composable("MainUi", content = { MainUi(navController = navController) })

             composable(route = BottomBarScreen.Home.route) {
                 CategoriesScreen(navController = navController)

             }
             composable(route = BottomBarScreen.Home.route) {
                 HomeScreen(navController = navController)

             }
             composable(route = BottomBarScreen.Settings.route) {
                 OffersScreen(navController = navController)

             }*/

           /* composable(route = BottomBarScreen.Services.path) {
                ServicesScreen(navController = navController)
            }


            composable(route = BottomBarScreen.Cart.path) {
                CartScreen(navController = navController)

            }*/
        })
}
