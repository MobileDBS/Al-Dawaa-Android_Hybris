package com.kr.aldawaa.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kr.ui_cart.ui.CartScreen
import com.kr.ui_categories.ui.screen.CategoriesScreen
import com.kr.ui_home.ui.HomeScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,

        startDestination = BottomBarScreen.Home.route
    ) {

        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Categories.route) {
            CategoriesScreen(navController)
        }
        composable(route = BottomBarScreen.Settings.route) {
            CartScreen(navController)
        }
    }
}
/*
@Composable
fun MainUi(navController: NavHostController) {


  //  NavigationUi(navController = navController)
}*/

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
  //  val badgeCount: Int = 0
) {
    object Categories : BottomBarScreen(
        route = "Categories",
        title = "Categories",
        icon = Icons.Default.Settings
    )

    object Home : BottomBarScreen(
        route = "home",
        title = "home",
        icon = Icons.Default.List
    )

    object Settings : BottomBarScreen(
        route = "cart",
        title = "cart",
        icon = Icons.Default.Settings
    )
}









/*

@Composable
fun MainUi(navController: NavHostController) {


    NavigationUi(navController = navController)
}
sealed class Screen(val name: String, val path: String, val icon: ImageVector) {
    object Shop : Screen(name = "Shop", path = "Categories", icon = Icons.Filled.List)
    object Offers : Screen(name = "Offers", path = "offers", icon = Icons.Filled.List)
    object Home : Screen(name = "Home", path = "home", icon = Icons.Filled.List)
    object Services : Screen(name = "Services", path = "services", icon = Icons.Filled.List)
    object Cart : Screen(name = "Cart", path = "cart", icon = Icons.Filled.Settings)

}*/


