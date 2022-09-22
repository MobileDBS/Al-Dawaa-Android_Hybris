package com.kr.aldawaa

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.kr.aldawaa.ui.theme.AlDawaaHybrisTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlDawaaHybrisTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   // GifImage()
                    DialogBox()
                }
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
            ImageRequest.Builder(context).data(data = R.raw.splash_gif).apply(block = {
                size(Size.ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello00 $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlDawaaHybrisTheme {
        Greeting("Android")
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
                modifier = Modifier) {

                Text(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp),
                    textAlign = TextAlign.Center
                    ,
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
                            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 24.dp, end = 24.dp).weight(0.5f),
                            textAlign = TextAlign.Center,
                            text = "Settings",
                            style = TextStyle(
                                fontSize = 16.sp),
                            color = Color.Blue,

                            )

                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                        Text(
                            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 24.dp, end = 24.dp).weight(0.5f),
                            textAlign = TextAlign.Center,
                            text = "Ok",
                            style =  TextStyle(fontSize = 16.sp),
                            color = Color.Blue,
                        )

                }
            }

        }
    }
}