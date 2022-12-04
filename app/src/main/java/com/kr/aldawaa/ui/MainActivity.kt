package com.kr.aldawaa.ui

import android.app.DatePickerDialog
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.util.Log
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.google.android.material.datepicker.MaterialDatePicker
import com.kr.aldawaa.R
import com.kr.aldawaa.ui.theme.AlDawaaHybrisTheme
import com.kr.network.ConnectivityObserver
import com.kr.network.NetworkConnectivityObserver
import com.kr.ui_categories.ui.categoriesui.CategoriesViewModel
import com.kr.ui_login.ui.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.DelicateCoroutinesApi

@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterialApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
@Inject
     lateinit var connectivityObserver: NetworkConnectivityObserver

    @OptIn(ExperimentalMaterialApi::class, DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlDawaaHybrisTheme{

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
                    Surface(color = MaterialTheme.colors.background) {
                        // GifImage()
                        //  DialogBox()
                        // DialogBox()
                        Greeting()
                        NavigationController()
                    }

                    ///////////////End Navigation Bar///////////////////////
                }
            }
        }
        }





    @Composable
    fun GifImage(
        modifier: Modifier = Modifier,
    ) {
        val context = LocalContext.current
        val imageLoader = ImageLoader.Builder(context)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(
                    data =
                    R.raw.splash_gif
                ).apply(block = {
                    size(Size.ORIGINAL)
                }).build(), imageLoader = imageLoader
            ),
            contentDescription = null,
            modifier = modifier.fillMaxWidth(),
        )
    }

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

    @Preview()
    @Composable
    fun DialogBox(
    ) {

        val context = LocalContext.current.applicationContext

        val buttonCorner = 6.dp

        Dialog(
            onDismissRequest = {
            }
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(size = 20.dp),

                ) {

                Column(
                    modifier = Modifier
                ) {

                    Text(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp),
                        textAlign = TextAlign.Center,
                        text = "Al Dawaa” Would Like to Access the Camera",
                        style = TextStyle(
                            color = Color.Black.copy(alpha = 0.95f),
                            fontSize = 16.sp,
                            lineHeight = 22.sp
                        )
                    )

                    Divider(color = Color.LightGray, thickness = 1.dp)


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 10.dp,
                            alignment = Alignment.CenterHorizontally
                        )
                    ) {

                        // Cancel button
                        Text(
                            modifier = Modifier
                                .padding(top = 20.dp, bottom = 20.dp, start = 24.dp, end = 24.dp)
                                .weight(0.5f),
                            textAlign = TextAlign.Center,
                            text = "Settings",
                            style = TextStyle(
                                fontSize = 16.sp
                            ),
                            color = Color.Blue,

                            )

                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(1.dp)
                        )
                        Text(
                            modifier = Modifier
                                .padding(top = 20.dp, bottom = 20.dp, start = 24.dp, end = 24.dp)
                                .weight(0.5f),
                            textAlign = TextAlign.Center,
                            text = "Ok",
                            style = TextStyle(fontSize = 16.sp),
                            color = Color.Blue,
                        )

                    }
                }

            }
        }
    }