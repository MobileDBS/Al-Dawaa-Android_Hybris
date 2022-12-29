@file:Suppress("DEPRECATION")
@file:OptIn(ExperimentalFoundationApi::class, DelicateCoroutinesApi::class)

package com.kr.ui_entry.ui


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.akexorcist.localizationactivity.core.LanguageSetting.setLanguage
import com.facebook.*
import com.facebook.login.LoginManager
import com.kr.components.ui.theme.*
import com.kr.ui_entry.R
import com.kr.ui_entry.ui.facebookAuthentication.FBLoginActivity
import com.kr.ui_entry.ui.googleAuthentication.AuthScreen
import com.kr.ui_entry.ui.googleAuthentication.AuthViewModel
import com.kr.ui_entry.ui.googleAuthentication.Googletokenid
import com.kr.ui_entry.ui.googleAuthentication.getGoogleSignInClient
import com.kr.ui_entry.ui.twitterAuthentication.TwitterConstants
import com.kr.ui_entry.ui.twitterAuthentication.TwitterScreen
import com.kr.ui_login.ui.LoginScreen
import kotlinx.coroutines.*
import twitter4j.Twitter
import twitter4j.TwitterAPIConfiguration
import twitter4j.TwitterBase
import twitter4j.TwitterFactory
import ui_register.ui.SignupScreen
import java.util.*


@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
@SuppressLint("ResourceType", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EntryScreen(navController: NavController , onItemClick: (String) -> Unit) {
    val authViewModel: AuthViewModel = hiltViewModel()
     val twitter: TwitterFactory?=null
    val twitter1: Twitter?=null
    lateinit var twitter2: TwitterAPIConfiguration
    lateinit var twitter3: TwitterBase

    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
//    val scaffoldState = rememberScaffoldState()
    val languages = listOf("English", "العربية")

    var chosenlanguage by rememberSaveable { mutableStateOf("English") }
    val errorMessage = "name format is invalid"

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
//        scaffoldState = scaffoldState
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(color = PrimaryColor)
                .verticalScroll(rememberScrollState())

        ) {
            Spacer(modifier = Modifier.padding(8.dp))


            Image(
                modifier = Modifier
                    .width(105.dp)
                    .height(52.dp)
                    .background(color = PrimaryColor),
                painter = painterResource(R.drawable.logo_al_dawaa),
                contentDescription = "login image",
                contentScale = ContentScale.FillBounds,
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = stringResource(id = R.string.wellcometoaldawaa),
                fontSize = 25.sp,
                color = White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.padding(6.dp))


        Box() {


            OutlinedButton(
                colors = ButtonDefaults.buttonColors(containerColor = Transparent),
                border = BorderStroke(0.dp , color = PrimaryColor),
                onClick = { expanded = !expanded }, modifier = Modifier.background(
                    color = Transparent
                )
            ) {
                Text(chosenlanguage, color = White)
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    tint = White,
                    contentDescription = null,

                    )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(color = WhiteColor),
                ) {
                languages.forEach { label ->
                    DropdownMenuItem(modifier = Modifier.background(WhiteColor), onClick = {
                        when (label) {
                            "English" -> {
                                chosenlanguage = label
                                setLanguage(context, Locale("en"))
//                                (context as? Activity)?.recreate()
                                onItemClick("English")

                            }
                            "العربية" -> {
                                chosenlanguage = label
                                setLanguage(context, Locale("ar"))
//                                (context as? Activity)?.recreate()
                                onItemClick("العربية")



                            }
                        }
                    }, text = { Text(text = label , style = MaterialTheme.typography.bodyLarge) })
                }
            }
        }

            Spacer(modifier = Modifier.padding(10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,

                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .clip(
                        shape = Shapes.large.copy(
                            bottomStart = ZeroCornerSize,
                            bottomEnd = ZeroCornerSize
                        )
                    )
                    // .background(color = White)
                    .paint(
                        painterResource(id = R.drawable.logo),
                        contentScale = ContentScale.FillBounds
                    )


            ) {
                Spacer(modifier = Modifier.padding(15.dp))


                var selectedIndex by remember { mutableStateOf(0) }

                val list = listOf(
                    stringResource(id = R.string.signintap),
                    stringResource(id = R.string.signuptap)
                )

                TabRow(selectedTabIndex = selectedIndex,
                    containerColor = Transparent,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .clip(RoundedCornerShape(50))
                        ,
                    divider = { TabRowDefaults.Divider(color = Transparent) },
                    indicator = { tabPositions: List<TabPosition> ->

                        //   Box {          colors.primaryVariant.red              }
                    }
                ) {
                    list.forEachIndexed { index, text ->
                        val selected = selectedIndex == index
                        Tab(
                            modifier = if (selected) Modifier
                                .clip(shape = ShapeBigButtons.large)
                                .background(
                                    SecondaryColor,
                                )
                            else Modifier
                                .clip(shape = ShapeBigButtons.large)
                                .background(
                                    Color.Transparent
                                ),
                            selected = selected,
                            onClick = { selectedIndex = index },
                            text = { Text(text = text, color = PrimaryColor  , style = MaterialTheme.typography.bodyLarge) }
                        )

                    }


                }

                when (selectedIndex) {
                    0 -> {
                        LoginScreen(navController = navController)
                    }

                    1 -> {
                         SignupScreen(navController = navController)

                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.background(Transparent)
                ) {



                        Text(
                        text = stringResource(id = R.string.orsigninwith),
                        fontSize = 15.sp,
                        color = PrimaryColor,
                            style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.padding(15.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    ) {

                        Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                            Box(
                                modifier = Modifier
                                    .size(58.dp, 58.dp)
                                    .paint(
                                        painterResource(
                                            id = R.drawable.googlelogo
                                        )
                                    ),

                                ) {
                              //  GoogleLogin(navController = navController)
                               AuthScreen(authViewModel = authViewModel,navController)
                            }


                           Button(onClick = {
                               getGoogleSignInClient(context).signOut()
                                 Googletokenid=""


                           }, modifier = Modifier
                               .size(10.dp, 10.dp)
                               .background(Unspecified),
                               colors = ButtonDefaults.buttonColors(Red)
                               .background(Transparent),
                               colors = ButtonDefaults.buttonColors(Unspecified)
                           ) {

                           }
                        }



                        Spacer(modifier = Modifier.padding(4.dp))

                            //facebook
                        Column(verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .size(58.dp, 58.dp)
                                    .paint(
                                        painterResource(
                                            id = R.drawable.facebooklogo
                                        )
                                    ),
                            ) {
                                FacebookLogin(navController)
                            }
                            Button(
                                onClick = {


                                    if (AccessToken.getCurrentAccessToken() == null) {
                                        Toast.makeText(context, "user is logged out ", Toast.LENGTH_SHORT).show()
                                        // already logged out
                                    }else{
                                        Toast.makeText(context, "user is Login wait for logout  ", Toast.LENGTH_SHORT).show()

                                        GraphRequest(
                                            AccessToken.getCurrentAccessToken(),
                                            "/me/permissions/",
                                            null,
                                            HttpMethod.DELETE,
                                            GraphRequest.Callback {
                                                LoginManager.getInstance().logOut()
                                                Log.e("facebooklogout response : ", "${it.request.accessToken?.token}")


                                            }).executeAsync()

                                    }

                                }, modifier = Modifier
                                    .size(10.dp, 10.dp)
                                    .background(Unspecified),
                                colors = ButtonDefaults.buttonColors(Unspecified)
                                    .background(Transparent),
                                colors = ButtonDefaults.buttonColors(Transparent)
                            ) {

                            }

                        }


                        Spacer(modifier = Modifier.padding(4.dp))
                        Column(verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally) {

                        }
                        //Twitter
                            Box(
                                modifier = Modifier
                                    .size(58.dp, 58.dp)
                                    .paint(
                                        painterResource(
                                            id = R.drawable.twitterlogo
                                        )
                                    )
                            ) {
                                TwitterScreen {

                                }
                                     }

                        Button(
                            onClick = {

                                CookieSyncManager.createInstance(context)
                                val cookieManager = CookieManager.getInstance()
                                cookieManager.removeSessionCookie()
                                twitter1?.setOAuthConsumer(
                                    TwitterConstants.CONSUMER_KEY,
                                    TwitterConstants.CONSUMER_SECRET)
                                twitter1?.oAuthAccessToken=null
                               twitter?.instance?.oAuthAccessToken=null
                               /* val shared = context.getSharedPreferences("twitter",Context.MODE_PRIVATE)

                                shared.edit().putString("oauth_token","").apply()
                                shared.edit().putString("oauth_token_secret", "").apply()
*/

                                      }, modifier = Modifier
                                .size(10.dp, 10.dp)
                                .background(Transparent),
                            colors = ButtonDefaults.buttonColors(Transparent)
                        ) {

                        }
                            }

                    }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = stringResource(id = R.string.continueasaguest ),
                    style = MaterialTheme.typography.bodyLarge,
                    color = PrimaryColor,
                    modifier = Modifier.clickable {
                        // navController.navigate("")
                        Toast.makeText(context, "Wellcome to Home ", Toast.LENGTH_SHORT).show()

                    })
                Spacer(modifier = Modifier.padding(10.dp))

                Spacer(modifier = Modifier.padding(15.dp))

            }



            }

        }

    }



@Composable
fun FacebookLogin(navController:NavController) {
    val context = LocalContext.current


    val facebookSignRequest =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val data = result.data?.getStringExtra(FBLoginActivity.EXTRA_DATA_FB)
                val accessToken: AccessToken? = AccessToken.getCurrentAccessToken()
                //do something with data
                val datax = result.data?.extras.toString()
                val dataxe = result.data?.getStringExtra(FBLoginActivity.EXTRA_DATA_FB)
                Log.d("facebook", "data is ${result.toString()}")
                Log.d("facebook", "data is ${datax.toString()}")
                Log.d("facebook", "data is ${dataxe.toString()}")


                val request = GraphRequest.newMeRequest(
                    accessToken,
                    callback = GraphRequest.GraphJSONObjectCallback { obj, response ->
                        val id: String = obj?.getString("id").toString()
                        val name: String = obj?.getString("name").toString()
                        val email: String = obj?.getString("email").toString()
                        // val pictureUri: String = obj?.getString("pictureUri").toString()
                        val picture: String = obj?.getString("picture").toString()

                        Log.e("facebookname1 : ", id)
                        Log.e("facebooklink1 : ", name)
                        Log.e("facebookmail1 : ", email)
                        Log.e("facebookpicture1 : ", picture)
                    })

                val parameters = Bundle()
                parameters.putString("fields", "id,name,email,picture")

                request.parameters = parameters
                request.executeAsync()
                Log.e("facebookparam : ", parameters.toString())
                Log.e("facebook : ", accessToken.toString())

                Log.e("facebook : ", accessToken?.expires.toString())

                Log.e("facebook : ", accessToken?.userId.toString())




            }
        }

   IconButton(onClick = {
       if (AccessToken.getCurrentAccessToken() == null) {
           facebookSignRequest.launch(FBLoginActivity.getInstance(context))

       }else{
           navController.navigate("MainUi")
       }


   }, modifier = Modifier
       .background(Unspecified)
       .fillMaxSize()) {
    //   Icon(painter = painterResource(id = R.drawable.ic_facebook)  , contentDescription ="facebook icon" )

   }
}





