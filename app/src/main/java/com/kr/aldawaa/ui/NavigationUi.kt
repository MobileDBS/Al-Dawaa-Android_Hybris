@file:OptIn(ExperimentalMaterial3Api::class)

package com.kr.aldawaa.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)
                    },
    ) {
        innerPadding->
        Box(modifier = Modifier.padding(innerPadding)){
            BottomNavGraph(navController = navController)
        }

    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Shop,
        BottomBarScreen.Offers,
        BottomBarScreen.Home,
        BottomBarScreen.Services,
        BottomBarScreen.Cart,
        )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(backgroundColor = Color.White) {

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
            Text(text = screen.name)
        },
        icon = {

            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon",
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.path
        } == true,
        unselectedContentColor = androidx.compose.material.LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.path) {
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
