package com.kr.aldawaa.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainUi(navController: NavHostController) {
    NavigationUi(navController = navController)
}
sealed class Screen(val name: String, val path: String, val icon: ImageVector) {
    object Shop : Screen(name = "Shop", path = "shop", icon = Icons.Filled.List)
    object Offers : Screen(name = "Offers", path = "offers", icon = Icons.Filled.List)
    object Home : Screen(name = "Home", path = "home", icon = Icons.Filled.List)
    object Services : Screen(name = "Services", path = "services", icon = Icons.Filled.List)
    object Cart : Screen(name = "Cart", path = "cart", icon = Icons.Filled.Settings)

}