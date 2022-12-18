@file:OptIn(ExperimentalMaterial3Api::class)

package com.kr.aldawaa.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kr.components.FloatingButton
import com.kr.components.ExtendedFloatingActionButton
import com.kr.components.FloatingButtonWithContent

@OptIn(ExperimentalFoundationApi::class,
    ExperimentalMaterialApi::class)
@Composable

fun MainScreen() {
    val navController = rememberNavController()
    var isFloatingButtonClicked by rememberSaveable { mutableStateOf(false) }
    var isExtendedFloatingButtonClicked by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        bottomBar = { BottomBar(navController = navController )
                    } ,
    ) {
        innerPadding->
        Box(modifier = Modifier.padding(innerPadding)){

            BottomNavGraph(navController = navController)

            FloatingButton(onItemClick = {isFloatingButtonClicked = true })

            if (isFloatingButtonClicked) {
                FloatingButton(onItemClick = { isFloatingButtonClicked = false })
                ExtendedFloatingActionButton(onItemClick = {isExtendedFloatingButtonClicked = true })
            }

            if (isExtendedFloatingButtonClicked) {
                ExtendedFloatingActionButton(onItemClick = { isExtendedFloatingButtonClicked = false })
                FloatingButtonWithContent()
            }

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
               // imageVector = screen.icon,
                painter = painterResource(id = screen.icon),
                contentDescription = "Navigation Icon",
                tint = Color.Unspecified
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.path
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.path) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

