package com.kr.aldawaa.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.productlist.ProductListScreen
import com.kr.ui_cart.ui.CartScreen
import com.kr.ui_categories.ui.categoriesdetailsui.CategoryDetailsScreen
import com.kr.ui_categories.ui.categoriesui.CategoriesScreen
import com.kr.ui_home.ui.HomeScreen
import com.kr.ui_offers.ui.OffersScreen
import com.kr.ui_services.ui.ServicesScreen


@ExperimentalMaterial3Api
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,

        startDestination = BottomBarScreen.Home.path
    ) {

        composable(route = BottomBarScreen.Home.path) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Shop.path) {
            CategoriesScreen(navController)
        }
        composable(route = BottomBarScreen.Offers.path) {
            OffersScreen(navController)
        }

        composable(route = BottomBarScreen.Services.path) {
            ServicesScreen(navController)
        }

        composable(route = BottomBarScreen.Cart.path) {
            CartScreen(navController)
        }

        composable("Category_Items", content = { CategoryDetailsScreen(navController = navController) })

        composable("Product_List", content = { ProductListScreen(navController=navController) })
    }
}
/*
@Composable
fun MainUi(navController: NavHostController) {


  //  NavigationUi(navController = navController)
}*/

sealed class BottomBarScreen(
    val name: String,
    val path: String,
    val icon: ImageVector,
  //  val badgeCount: Int = 0
) {
    object Shop : BottomBarScreen(
        name = "Shop",
        path = "Categories",
        icon = Icons.Filled.List
    )

    object Offers : BottomBarScreen(
        name = "Offers",
        path = "offers",
        icon = Icons.Filled.List
    )


    object Home : BottomBarScreen(
        name = "Home",
        path = "home",
        icon = Icons.Filled.List
    )


    object Services : BottomBarScreen(
        name = "Service",
        path = "service",
        icon = Icons.Filled.List
    )


    object Cart : BottomBarScreen(
        name = "Cart",
        path = "cart",
        icon = Icons.Filled.Settings
    )
  /*  object ProductList : BottomBarScreen(
        name = "ProductList",
        path = "Product_List",
        icon = Icons.Filled.Settings
    )*/
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


