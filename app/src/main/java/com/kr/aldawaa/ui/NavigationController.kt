@file:OptIn(ExperimentalCoroutinesApi::class, ExperimentalCoroutinesApi::class)

package com.kr.aldawaa.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kr.ui_categories.ui.categoriesdetailsui.CategoryDetailsScreen
import com.kr.ui_login.ui.EntryScreen
import com.kr.ui_otp.ui.OtpScreen
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ui_forgetpassword.ui.ForgetPasswordScreen
import ui_forgetpassword.ui.ForgetSuccess
import ui_forgetpassword.ui.NewPasswordScreen


@ExperimentalMaterial3Api
@DelicateCoroutinesApi
@ExperimentalMaterialApi
@Preview
@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login_page",
        builder = {

            composable("Login_page", content = { EntryScreen(navController = navController) })
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
