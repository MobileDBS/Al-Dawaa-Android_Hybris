
package com.kr.aldawaa.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kr.ui_cart.ui.CartScreen
import com.kr.ui_home.ui.HomeScreen
import com.kr.ui_offers.ui.OffersScreen
import com.kr.ui_services.ui.ServicesScreen





@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Categories,
        BottomBarScreen.Home,
        BottomBarScreen.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
           /* Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )*/
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = androidx.compose.material.LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}



/*

@Composable
fun NavigationUi(
  navController: NavHostController,
) {
  val bottomBarVisibility = rememberSaveable { (mutableStateOf(true)) }
  val items = listOf(Screen.Shop, Screen.Offers , Screen.Home , Screen.Services , Screen.Cart)
  */
/*@ExperimentalMaterialApi
  @Composable
  fun BottomNavigationBar(
    items: List<NavigationBarItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
  ) {}*//*


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
}*/
