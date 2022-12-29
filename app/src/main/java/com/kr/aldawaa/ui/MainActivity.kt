package com.kr.aldawaa.ui

import android.Manifest
import android.location.Location
import android.app.DatePickerDialog
import android.content.Context
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate

import com.kr.aldawaa.LocationClass
  import com.google.android.gms.auth.api.signin.GoogleSignIn
  import com.google.android.gms.auth.api.signin.GoogleSignInClient
  import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.kr.aldawaa.R
import com.kr.components.CustomPermission
import com.kr.components.StartPermissionSetting
import com.kr.components.ui.theme.AlDawaaHybrisTheme
import com.kr.network.NetworkConnectivityObserver
import com.kr.ui_categories.ui.categoriesui.CategoriesViewModel
import com.kr.ui_entry.ui.twitterAuthentication.TwitterConstants
import com.kr.ui_login.ui.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import java.util.*
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity(),LocationClass.Interface {


    private val localizationDelegate = LocalizationActivityDelegate(this)

    @Inject
    lateinit var imageLoader: ImageLoader


    override fun attachBaseContext(newBase: Context) {
        applyOverrideConfiguration(localizationDelegate.updateConfigurationLocale(newBase))
        super.attachBaseContext(newBase)
    }

//    var locationClass=LocationClass(this)
    @Inject
    lateinit var connectivityObserver: NetworkConnectivityObserver

     val coroutineScope :CoroutineScope = CoroutineScope(Dispatchers.IO)
    //Google
/*

    private fun getGoogleLoginAuth(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(getString(R.string.gcp_id))
            .requestId()
            .requestProfile()
            .build()
        return GoogleSignIn.getClient(this, gso)
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coroutineScope.launch(Dispatchers.IO) {
            val results = coroutineScope.async { isLoggedIn() }
            val result = results.await()
            if (result) {
                // Show the Activity with the logged in user
                Log.d("LoggedIn Twitter?: ", "YES")
                //   finish()
            } else {
                // Show the Home Activity
                Log.d("LoggedIn Twitter?: ", "NO")
                //   finish()

            }
        }
        setContent {
            //locationClass.GetLastLocation()
            AlDawaaHybrisTheme {

                //BottomSheet
//                Surface(color = MaterialTheme.colors.background) {
//                    CustomModalBottomSheet(list)
//                }


//                val viewModel: LoginViewModel by hiltViewModel()
//                            val state = viewModel.state.value
//
//                Log.v("loginResponse" , state.error.toString())

                /////////////////Start Navigation Bar////////////////
                val viewModel: LoginViewModel = hiltViewModel()
                val state = viewModel.state.value
                val categoriesViewModel: CategoriesViewModel = hiltViewModel()
                val categoriesstate = categoriesViewModel.state.value

                Log.v("categorieslist Response", categoriesstate.Categorieslist.toString())
                Log.v("Login Response", state.error.toString())

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    //  Greeting()
                    NavigationController()
                    CustomPermission(permissions = listOf(
                        Manifest.permission.CAMERA
                    ), permissionContent = {
                    })

                    ///////////////End Navigation Bar///////////////////////
                }
            }

        }
    }

    private suspend fun isLoggedIn(): Boolean {
        val sharedPref = this.getSharedPreferences("twitter",Context.MODE_PRIVATE)
        val accessToken = sharedPref.getString("oauth_token","")
        val accessTokenSecret = sharedPref.getString("oauth_token_secret", "")
        val builder = ConfigurationBuilder()
        builder.setOAuthConsumerKey(TwitterConstants.CONSUMER_KEY)
            .setOAuthConsumerSecret(TwitterConstants.CONSUMER_SECRET)
            .setOAuthAccessToken(accessToken)
            .setOAuthAccessTokenSecret(accessTokenSecret)
        val config = builder.build()
        val factory = TwitterFactory(config)
        val twitter = factory.instance
        return try {
            withContext(Dispatchers.IO) { twitter.verifyCredentials() }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun findLocation(location: Location) {
        Log.v("LocationFromHomeActivity",location.toString())
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    val context = LocalContext.current

    var date by remember{
        mutableStateOf("")
    }
/*    MaterialDatePicker
        .Builder
        .datePicker()
        .setTitleText("Select date of birth")
        .build()
        .show(supportFragmentManager, "DATE_PICKER")*/

    val datePickerDialog = DatePickerDialog(
        context,R.style.MyDatePickerDialogTheme,
        { d, year1, month1, day1 ->
            val month = month1 + 1
            date = "$day1 - $month - $year1"
        },year , month , day
    )


    Scaffold(
        topBar = {
            TopAppBar (
                title = { Text(text = "Calender View")},
                )
        },
        content = {
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ){
                /*       AndroidView(factory = { CalendarView(it) }, update = {
                           it.setOnDateChangeListener { calendarView, year, month, day ->
                               date = "$day - ${month +1} - $year"
                           }
                       })*/
                datePickerDialog.show()

                Text(text = date)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlDawaaHybrisTheme {
        Greeting()
    }


}

