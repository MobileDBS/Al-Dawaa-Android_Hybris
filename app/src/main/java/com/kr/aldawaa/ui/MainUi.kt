@file:OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)

package com.kr.aldawaa.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.kr.aldawaa.R
import com.kr.components.*
import com.kr.productlist.ProductListScreen
import com.kr.ui_cart.ui.CartScreen
import com.kr.ui_categories.ui.categoriesdetailsui.CategoryDetailsScreen
import com.kr.ui_categories.ui.categoriesui.CategoriesScreen
import com.kr.ui_filter.FilterScreen
import com.kr.ui_home.ui.HomeScreen
import com.kr.ui_offers.ui.OffersScreen
import com.kr.ui_services.ui.CameraScreen

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
            OffersScreen(navController = navController)
//            FilterScreen(navController)
        }

        composable(route = BottomBarScreen.Services.path) {
            ServicesScreen(navController)
        }

        composable(route = BottomBarScreen.Cart.path) {
            CartScreen(navController)
        }
        composable(route = BottomBarScreen.Cart.path) {
            CartScreen(navController)
        }
        composable("Category_Items", content = {
            CategoryDetailsScreen(navController = navController) })


        composable("Filter_Screen", content = { FilterScreen(navController = navController) })

        composable("Category_Items", content = { CategoryDetailsScreen(navController = navController) })

        composable("Product_List", content = { ProductListScreen(navController=navController, {}) })
        composable("Camera_Screen?showvalu={showvalu}", arguments = listOf(navArgument(name ="showvalu" ){
            type = NavType.BoolType
        }), content = {
            val show = it.arguments?.getBoolean("showvalu",false)
            CameraScreen(navController=navController, showGallery = show!!) })


//        dialog("BottomSheetScaffold") {
//            BottomSheetScaffold(navController=navController)
//        }

        dialog("CustomModalBottomSheet") {
            CustomModalBottomSheet(navController = navController)
        }

        dialog("CustomModalBottomSheet2") {
            // The content here will be added to a Dialog() Composable
            CustomModalBottomSheet2(navController=navController )
        }

        dialog("CustomModalBottomSheet3") {
            // The content here will be added to a Dialog() Composable
            CustomModalBottomSheet3(navController=navController  )
        }

        composable("Map", content = { CustomMap() })



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
    val icon: Int,
  //  val badgeCount: Int = 0
) {
    object Shop : BottomBarScreen(
        name = "Shop",
        path = "Categories",
        icon = R.drawable.ic_shop
    )

    object Offers : BottomBarScreen(
        name = "Offers",
        path = "FilterScreen",
        icon = R.drawable.ic_offers
    )


    object Home : BottomBarScreen(
        name = "Home",
        path = "home",
        icon = R.drawable.ic_home
    )


    object Services : BottomBarScreen(
        name = "Service",
        path = "service",
        icon = R.drawable.ic_services
    )


    object Cart : BottomBarScreen(
        name = "Cart",
        path = "cart",
        icon = R.drawable.ic_cart
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


