package com.kr.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kr.components.ui.theme.*

@ExperimentalFoundationApi
    @Composable
    fun FloatingButton(onItemClick: (Boolean) -> Unit) {//onItemClick: (String) -> Unit
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp, end = 16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = {
                    onItemClick(true)
                },
                shape = RoundedCornerShape(40.dp),
                containerColor = Color(0xffffffff),
                contentColor = Color.Unspecified,

            ) {
                Icon(painter = painterResource(R.drawable.ic_chatbot), "")
            }

            Icon(
                painter = painterResource(R.drawable.ic_close),
                "", tint = Color.Unspecified,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 35.dp)
                    .height(20.dp)
                    .width(20.dp)
            )

        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun ExtendedFloatingActionButton(onItemClick: (Boolean) -> Unit) {
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 25.dp, bottom = 20.dp, end = 25.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            ExtendedFloatingActionButton(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 0.dp),
                onClick = {
                    onItemClick(true)
                },
                shape = RoundedCornerShape(40.dp),
                text = {
                    Text(
                        text = "Speak to a pharmacist",
                        color = PrimaryColor,
                    )
                },
                containerColor = Color.White,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_chatbot),
                        "",
                        tint = Color.Unspecified
                    )
                },

                )
            Icon(
                painter = painterResource(R.drawable.ic_close),
                "", tint = Color.Unspecified,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 40.dp)
                    .height(24.dp)
                    .width(24.dp)
            )

        }


    }

    @ExperimentalFoundationApi
    @Composable
    fun FloatingButtonWithContent() {
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 25.dp, bottom = 20.dp, end = 25.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 0.dp),
                onClick = {
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
                            colors = ButtonDefaults.buttonColors(containerColor = SecondaryColor),
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
                                colors = ButtonDefaults.buttonColors(containerColor = SecondaryColor),
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
                                colors = ButtonDefaults.buttonColors(containerColor = SecondaryColor),
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

                }, containerColor = WhiteColor
            )


            Icon(
                painter = painterResource(R.drawable.ic_close),
                "", tint = Color.Unspecified,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 155.dp)
                    .height(24.dp)
                    .width(24.dp)

            )


        }

}
