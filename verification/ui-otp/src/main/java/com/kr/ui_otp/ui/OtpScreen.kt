@file:Suppress("DEPRECATION")
package com.kr.ui_otp.ui
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.ui.theme.*
import com.kr.ui_otp.R

import kotlinx.coroutines.*


@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@SuppressLint("ResourceType", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OtpScreen(navController: NavController) {

    val validationHelper: ValidationHelper = ValidationHelper()

    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    var isErrorOtp by rememberSaveable { mutableStateOf(false) }
    val otp = rememberSaveable { mutableStateOf("") }
    var otpVal: String? = null

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), scaffoldState = scaffoldState
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(color = PrimaryColor)
                .verticalScroll(rememberScrollState())
                .paint(painter = painterResource(id = R.drawable.group))


        ) {

            Spacer(modifier = Modifier.padding(15.dp))

            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(80.dp)
                    .background(color = PrimaryColor),

                painter = painterResource(R.drawable.ic_aldawaa_logo),
                contentDescription = "login image",
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Text(
                text = stringResource(id = R.string.forgetpassword),
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.padding(15.dp))

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
                    .paint(
                        painterResource(id = R.drawable.background),
                        contentScale = ContentScale.FillBounds
                    )


            ) {
                Spacer(modifier = Modifier.padding(15.dp))


                OTPTextFields(length = 4) { getOpt ->
                    otpVal=getOpt

                }

                Spacer(modifier = Modifier.padding(20.dp))


                Text(
                    text = stringResource(id = R.string.forgetdontrec),
                    color = PrimaryColor,
                    fontSize = 16.sp

                )
                Spacer(modifier = Modifier.padding(5.dp))


                Text(
                    text = stringResource(id = R.string.recendcode),
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp

                )



                Spacer(modifier = Modifier.padding(70.dp))


                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(53.dp)
                        .clip(shape = ShapeTabButtons.small)
                        .align(alignment = Alignment.CenterHorizontally)

                    ,
                    colors = ButtonDefaults.outlinedButtonColors(Color.Transparent),
                    shape = ShapeTabButtons.small,
                    border = BorderStroke(2.dp, PrimaryColor),

                    onClick = {

                        if (otpVal.toString() == "1234") {
                            Toast.makeText(context, "Verefication done  ", Toast.LENGTH_SHORT)
                                .show()
                            navController.navigate("Forget_Change_Password")
                        }

                    },


                    ) {
                    Text(
                        text = stringResource(id = R.string.forgetsend),
                        fontSize = 20.sp,
                        color = PrimaryColor,
                    )
                    Spacer(modifier = Modifier.padding(15.dp))

                }

            }
        }
    }

}


