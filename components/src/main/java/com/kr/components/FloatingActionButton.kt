package com.kr.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.SecondaryColor
import com.kr.components.ui.theme.WhiteColor
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun FloatingActionButton() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box{
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Simple Floating Action Button", Toast.LENGTH_SHORT).show()
                },
                backgroundColor = WhiteColor,
                contentColor = Color.Unspecified
            ) {
                Icon(painter = painterResource(R.drawable.ic_chatbot), "")
            }

            Icon(painter = painterResource(R.drawable.ic_close),
                "", tint = Color.Unspecified ,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .height(20.dp)
                    .width(20.dp)
            )

        }
        Spacer(modifier = Modifier.height(20.dp))

        Box (modifier = Modifier.padding(start = 25.dp, end = 25.dp)){
            ExtendedFloatingActionButton(
                modifier = Modifier.padding(start=10.dp , top= 10.dp , bottom= 10.dp , end =0.dp),
                onClick = {
                    Toast.makeText(
                        context,
                        "You clicked floating action button with circular shape....",
                        Toast.LENGTH_LONG
                    ).show()
                },
                shape = RoundedCornerShape(40.dp),
                text = {
                    Text(
                        text = "Speak to a pharmacist",
                        color = PrimaryColor,
                    )
                },
                backgroundColor = WhiteColor ,
                icon = { Icon(painter = painterResource(R.drawable.ic_chatbot), "" , tint = Color.Unspecified) },

                )
            Icon(painter = painterResource(R.drawable.ic_close),
                "", tint = Color.Unspecified ,
                modifier = Modifier.align(Alignment.TopEnd) .height(24.dp)
                    .width(24.dp)
            )

        }


        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.padding(start = 25.dp, end = 25.dp)) {
            FloatingActionButton(
                modifier = Modifier.padding(start=10.dp , top= 10.dp , bottom= 10.dp , end =0.dp),
                onClick = {
                    Toast.makeText(
                        context,
                        "You clicked floating action button with circular shape....",
                        Toast.LENGTH_LONG
                    ).show()
                },
                shape = RoundedCornerShape(20.dp),
                content = {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_chatbot),
                                "", tint = Color.Unspecified,
                                modifier = Modifier.padding(end = 6.dp)
                            )
                            Text(
                                text = (context.resources.getString(R.string.speak_to_pharmacist)),
                                color = PrimaryColor
                            )
                        }

                        Button(
                            onClick = {},
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor),
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .fillMaxWidth(),
                        ) {
                            Icon(
                                modifier = Modifier
                                    .padding(
                                        start = 16.dp,
                                        top = 8.dp,
                                        bottom = 8.dp,
                                        end = 4.dp
                                    )
                                    .align(CenterVertically),
                                painter = painterResource(R.drawable.ic_live_video_call),
                                contentDescription = "",
                                tint = Color.Unspecified
                            )

                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = 4.dp,
                                        top = 8.dp,
                                        bottom = 8.dp,
                                        end = 16.dp
                                    ),
                                text = context.resources.getString(R.string.live_video_call),
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center
                            )


                        }
                        Row {
                            Button(
                                modifier = Modifier
                                    .weight(0.5f)
                                    .padding(end = 4.dp),
                                onClick = {},
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor),
                                contentPadding = PaddingValues(0.dp),
                            ) {
                                Icon(
                                    modifier = Modifier.padding(
                                        start = 8.dp,
                                        top = 8.dp,
                                        bottom = 8.dp,
                                        end = 2.dp
                                    ),
                                    painter = painterResource(R.drawable.ic_call),
                                    contentDescription = "",
                                    tint = Color.Unspecified
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(
                                            start = 2.dp,
                                            top = 8.dp,
                                            bottom = 8.dp,
                                            end = 16.dp
                                        ),
                                    text = context.resources.getString(R.string.call),
                                    fontSize = 14.sp
                                )

                            }


                            Button(
                                modifier = Modifier
                                    .weight(0.5f)
                                    .padding(start = 4.dp),
                                onClick = {},
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor),
                                contentPadding = PaddingValues(0.dp),
                            ) {
                                Icon(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 8.dp,
                                        bottom = 8.dp,
                                        end = 2.dp
                                    ),
                                    painter = painterResource(R.drawable.ic_chat),
                                    contentDescription = "",
                                    tint = Color.Unspecified,
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(
                                            start = 2.dp,
                                            top = 8.dp,
                                            bottom = 8.dp,
                                            end = 16.dp
                                        ),
                                    text = context.resources.getString(R.string.chat),
                                    fontSize = 14.sp
                                )

                            }


                        }

                    }

                }, backgroundColor = WhiteColor
            )


            Icon(painter = painterResource(R.drawable.ic_close),
                "", tint = Color.Unspecified ,
                modifier = Modifier.align(Alignment.TopEnd)
            )


        }

    }


}
