package ui_forgetpassword.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.CustomOutlinedButton
import com.kr.ui_forgetpassword.R
import com.kr.components.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForgetPasswordScreen (navController: NavController) {

    val validationHelper : ValidationHelper = ValidationHelper()

    val context = LocalContext.current
//    val scaffoldState = rememberScaffoldState()
    var isErrorforget by rememberSaveable { mutableStateOf(false) }
    val forgetphone = rememberSaveable { mutableStateOf("") }

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
                text = stringResource(id = R.string.forgetpassword ),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge

            )

            Spacer(modifier = Modifier.padding(15.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,

                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(
                        shape = Shapes.large.copy(
                            bottomStart = ZeroCornerSize,
                            bottomEnd = ZeroCornerSize
                        )
                    )
                    // .background(color = White)
                    .paint(
                        painterResource(id = R.drawable.background),
                        contentScale = ContentScale.FillBounds,
                    )


            ) {
                Spacer(modifier = Modifier.padding(15.dp))

                    OutlinedTextField(

                        value = forgetphone.value,
                        onValueChange = {
                            forgetphone.value = it
                            isErrorforget = false
                        },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.phonenumber),
                                color = InputHint ,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        },
                        isError = isErrorforget,
                        // keyboardActions = KeyboardActions { validate(emailorphone.value) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),

                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .clip(shape = ShapeBigButtons.small)
                            .height(53.dp)
                            .background(color = InputColor),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        ), shape = ShapeBigButtons.small
                    )
                    if (isErrorforget) Text(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            // .align(alignment = Alignment.TopStart)
                            .padding(start = 20.dp),
                        text = "phone is empty",
                        color = ErrorColor,

                        )


                     Spacer(modifier = Modifier.padding(vertical = 120.dp))

                CustomOutlinedButton(onClick = {
                    if (!validationHelper.phonenumvalidation(forgetphone.value)){
                        isErrorforget = true
                    }
                    else {
                        navController.navigate("Forget_Password_Otp")
                        Toast.makeText(context, "code sent ", Toast.LENGTH_SHORT).show()
                    }
                }, statue = BTNSTATE.ACTIVE,
                contenttext = stringResource(id = R.string.forgetsend))



                }

            }
        }
    }



