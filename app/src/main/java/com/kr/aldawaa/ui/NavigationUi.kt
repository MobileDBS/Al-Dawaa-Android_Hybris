
package com.kr.aldawaa.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kr.ui_cart.ui.CartScreen
import com.kr.ui_home.ui.HomeScreen
import com.kr.ui_offers.ui.OffersScreen
import com.kr.ui_services.ui.ServicesScreen
import com.kr.ui_shop.ui.ShopScreen

@Composable
fun NavigationUi(
  navController: NavHostController,
) {
   val bottomBarVisibility = rememberSaveable { (mutableStateOf(true)) }
  val items = listOf(Screen.Shop, Screen.Offers , Screen.Home , Screen.Services , Screen.Cart)
  @ExperimentalMaterialApi
  @Composable
  fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
  ) {}
  Scaffold(
    bottomBar =
    {
      AnimatedVisibility(
        visible = bottomBarVisibility.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
          NavigationBar(Modifier.background(color = MaterialTheme.colorScheme.primary)) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { screen ->
              NavigationBarItem(
                icon = {
                  Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.name
                  )
                },
                label = { Text(text = screen.name) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.path } == true,
                onClick = {
                  navController.navigate(screen.path) {
                    popUpTo(navController.graph.findStartDestination().id) {
                      saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                  }
                })
            }
          }
        })
    }

  ) { innerPadding ->
//    NavHost(
//      navController = navController,
//      startDestination = Screen.Home.path,
//      modifier = Modifier.padding(innerPadding)
//    ) {
//      composable(Screen.Home.path) {
//        HomeScreen(navController = navController)
//      }
//      composable(route = Screen.Shop.path) {
//        ShopScreen(navController = navController)
//      }
//      composable(route = Screen.Offers.path) {
//        OffersScreen(navController = navController)
//
//      }
//      composable(route = Screen.Services.path) {
//        ServicesScreen(navController = navController)
//
//      }
//      composable(route = Screen.Cart.path) {
//        CartScreen(navController = navController)
//
//      }
//    }

  }
}