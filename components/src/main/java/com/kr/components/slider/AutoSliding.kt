package com.kr.components

import android.graphics.PorterDuff
import android.util.Log
import android.widget.RatingBar
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.pager.*
import com.kr.components.slider.natural
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalPagerApi
@Composable
fun AutoSliding() {
    var pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        Log.v("pagerState"," inside while ${pagerState.currentPage}")
        while (true) {
            yield()
            delay(200)
            tween<Float>(100)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Column(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Auto Sliding",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        HorizontalPager(count = natural.size,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 40.dp, 0.dp, 40.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp, 15.dp, 0.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                val natural = natural[page]
                // Log.v("page"," is: $page")
// Later, scroll to page 2
                scope.launch {
                    //   pagerState.scrollToPage(page+1)
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(
                            id = when (page) {
                                1 -> R.drawable.image_1
                                2 -> R.drawable.image_2
                                3 -> R.drawable.image_3
                                4 -> R.drawable.image_4
                                5 -> R.drawable.image_5
                                else -> R.drawable.image_1
                            }
                        ),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(15.dp)
                    ) {
                        Text(
                            text = natural.title,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        val ratingBar = RatingBar(
                            LocalContext.current, null, R.attr.ratingBarStyleSmall
                        ).apply {
                            rating = natural.rating
                            progressDrawable.setColorFilter(
                                android.graphics.Color.parseColor("#FFD700"),
                                PorterDuff.Mode.SRC_ATOP
                            )
                        }
                        AndroidView(
                            factory = { ratingBar },
                            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                        )

                        Text(
                            text = natural.desc,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                        )
                    }
                }
            }
        }

        //Horizontal dot indicator
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)

        )
    }
}