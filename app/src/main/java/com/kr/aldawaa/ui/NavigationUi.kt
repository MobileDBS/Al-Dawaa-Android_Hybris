@file:OptIn(ExperimentalMaterial3Api::class)

package com.kr.aldawaa.ui
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kr.aldawaa.R
import com.kr.aldawaa.ui.theme.ErrorColorLight
import com.kr.aldawaa.ui.theme.SecondaryColor
import WhiteColor
import PrimaryColor
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {TopAppBarCompose()},
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
               // imageVector = screen.icon,
                painter = painterResource(id = screen.icon),
                contentDescription = "Navigation Icon",
                tint = Color.Unspecified
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

@Composable
fun TopAppBarCompose(){
    val context = LocalContext.current
  TopAppBar(title = {
      Box(modifier = Modifier.fillMaxSize()) {
          Image(painterResource(id = R.drawable.arbahy),
              "logo",
          modifier = Modifier
              .size(80.dp)
              .align(Alignment.Center)
              .clickable {
                  Toast
                      .makeText(context, "Logo", Toast.LENGTH_SHORT)
                      .show()
              })}

  }
//  { Text(text = "Al-Dawaa", fontSize = 20.sp, color = SecondaryColor)}
      ,
  navigationIcon = {
                   IconButton(onClick = {
                       Toast.makeText(context, "Login", Toast.LENGTH_LONG).show()
                   }) {
                       userAvatarStatus("userWithAvatar")
                   }
  },
  actions = {
      IconButton(onClick = { Toast.makeText(context,"wishIcon",Toast.LENGTH_LONG) }) {
          Icon( painterResource(id = R.drawable.ic_home_heart), contentDescription = "favorite", tint = Color.Unspecified)
      }
  },
      backgroundColor = PrimaryColor
  )
}
@Composable
fun userAvatarStatus(status:String){
    when(status){
        "userWithAvatar" -> {
            Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painterResource(id = R.drawable.ic_user_avatar),"avatar")
            Column (modifier = Modifier.padding(5.dp)){
                Text(text = "Hi", color = WhiteColor)
                Text(text = "AbdElrahman", color = WhiteColor,maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }}
        "userWithoutAvatar" -> {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(id = R.drawable.ic_user_avatar),"avatar")
                Column {
                    Text(text = "Hi", color = WhiteColor)
                    Text(text = "AbdElrahman", color = WhiteColor,maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
//maxLines = 1, overflow = TextOverflow.Ellipsis
        }
        "guest" -> {
            Text(text = "Login", fontSize = 20.sp, color = WhiteColor, modifier = Modifier.padding(start = 10.dp))

        }
        else -> {

        }
    }

}