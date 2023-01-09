@file:OptIn(ExperimentalMaterial3Api::class)

package com.kr.aldawaa.ui

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.kr.aldawaa.R
import com.kr.components.*
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.WhiteColor
import com.kr.ui_entry.ui.twitterAuthentication.coroutineScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class,
    ExperimentalMaterialApi::class)
@Composable

fun MainScreen() {
    val navController = rememberNavController()
    var isFloatingButtonClicked by rememberSaveable { mutableStateOf(false) }
    var isExtendedFloatingButtonClicked by rememberSaveable { mutableStateOf(false) }

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = { TopAppBarCompose(context,imageLoader) },
        bottomBar = { BottomBar(navController = navController )
        } , content = {
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
    )

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
            Text(text = screen.name , style = MaterialTheme.typography.bodyMedium)
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



@Composable
fun TopAppBarCompose(context: Context, imageLoader: ImageLoader) {
    val navController = rememberNavController()
    val clicked = true


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
                    })
        }

    },
        navigationIcon = {
            IconButton(onClick = {
            }) {
                userAvatarStatus(context, imageLoader,"userWithImg")
            }
        },
        actions = {
            IconButton(onClick = { Toast.makeText(context, "wishIcon", Toast.LENGTH_LONG) }) {
                Icon(
                    painterResource(id = R.drawable.ic_home_heart),
                    contentDescription = "favorite",
                    tint = Color.Unspecified
                )
            }
        },
        backgroundColor = PrimaryColor
    )

}

@Composable
fun userAvatarStatus(context: Context, imageLoader: ImageLoader,status: String) {
    when (status) {
        "userWithImg" -> {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
                Toast
                    .makeText(context, "Go To Profile img", Toast.LENGTH_SHORT)
                    .show()
            }) {
                //TODO:Add click action --> go to profile
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(context)
                            .data(data = "https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80")
                            .crossfade(true)
                            .apply(block = {
                                size(Size.ORIGINAL)
                            }).build(), imageLoader = imageLoader
                    ),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "userImg",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(5.dp)) {
                    Text(text = "Hi", color = WhiteColor)
                    Text(
                        text = "AbdElrahman",
                        color = WhiteColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        "userWithAvatar" -> {
            Row(verticalAlignment = Alignment.CenterVertically ,modifier = Modifier.clickable {
                Toast
                    .makeText(context, "Go To Profile avatar", Toast.LENGTH_SHORT)
                    .show()
            }) {
                //TODO:Add click action --> go to profile
                Image(painterResource(id = R.drawable.ic_user_avatar), "avatar")
                Column {
                    Text(text = "Hi", color = WhiteColor)
                    Text(
                        text = "AbdElrahman",
                        color = WhiteColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        "guest" -> {
            Text(
                //TODO:Add click action --> go to login
                text = "Login",
                fontSize = 20.sp,
                color = WhiteColor,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Go To Login", Toast.LENGTH_SHORT)
                            .show()
                    }
            )

        }
        else -> {

        }
    }

}
