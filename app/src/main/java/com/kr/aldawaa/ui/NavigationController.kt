@file:OptIn(ExperimentalCoroutinesApi::class)

package com.kr.aldawaa.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kr.ui_cart.ui.CartScreen
import com.kr.ui_home.ui.HomeScreen
import com.kr.ui_login.ui.EntryScreen
import com.kr.ui_offers.ui.OffersScreen
import com.kr.ui_otp.ui.OtpScreen
import com.kr.ui_services.ui.ServicesScreen
import com.kr.ui_shop.ui.ShopScreen
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ui_forgetpassword.ui.ForgetPasswordScreen
import ui_forgetpassword.ui.ForgetSuccess
import ui_forgetpassword.ui.NewPasswordScreen


@DelicateCoroutinesApi
@ExperimentalMaterialApi
@Preview
@Composable
fun NavigationPage() {
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

            composable("MainUi", content = { MainUi(navController = navController) })

            composable(Screen.Home.path) {
                HomeScreen(navController = navController)
            }
            composable(route = Screen.Shop.path) {
                ShopScreen(navController = navController)
            }
            composable(route = Screen.Offers.path) {
                OffersScreen(navController = navController)

            }
            composable(route = Screen.Services.path) {
                ServicesScreen(navController = navController)

            }
            composable(route = Screen.Cart.path) {
                CartScreen(navController = navController)

            }
        }
    )
}
