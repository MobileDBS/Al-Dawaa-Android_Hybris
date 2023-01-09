package com.kr.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
import com.kr.components.ui.theme.ShapeBigButtons
import com.kr.components.ui.theme.Typography
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArbahyBottomSheet(navController: NavController) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { BottomSheet() },
        modifier = Modifier.fillMaxSize(),
        sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),

        ) {

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                coroutineScope.launch {
                    if (sheetState.isVisible) sheetState.hide()
                    else sheetState.show()
                }
            },
        ) {
            Text(text = "sheet")
        }
    }
}


@Composable
fun BottomSheet() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    modifier = Modifier.fillMaxWidth()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
       // modifier = Modifier.padding(start = 25.dp)
    ) {
        Spacer(modifier = Modifier.padding(15.dp))
        Card(modifier = Modifier
            .size(320.dp, 200.dp),
            contentColor = Color.White,
            backgroundColor = PrimaryColor,
            shape = ShapeBigButtons.small,
            content = {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 25.dp)
                    ) {

                        Text(
                            text = "Standard",
                            style = Typography.headlineMedium,
                            color = Color.White
                        )


                    }
                    Spacer(modifier = Modifier.padding(3.dp))

                    Divider(
                        color = Color.White,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(start = 25.dp)
                            .fillMaxWidth(0.9f)
                    )


                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 25.dp)
                    ) {

                        Column() {
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "58,003 ",
                                style = Typography.displaySmall,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))

                            Row() {

                                Image(
                                    painter = painterResource(id = R.drawable.new_arbahi),
                                    contentDescription = "Arbahi",
                                    modifier = Modifier.size(44.dp, 25.dp)
                                )
                                Spacer(modifier = Modifier.padding(5.dp))
                                Text(
                                    text = "Arbahi Points",
                                    style = Typography.headlineSmall,
                                    color = Color.White
                                )
                            }

                        }
                        Spacer(modifier = Modifier.padding(25.dp))

                        Image(
                            painter = painterResource(id = R.drawable.qr_code),
                            contentDescription = "qr code",
                            modifier = Modifier.size(53.dp, 53.dp)
                        )



                    }
                    Spacer(modifier = Modifier.padding(10.dp))

                    Column(modifier = Modifier.padding(start = 25 .dp)) {
                        Box(
                            Modifier
                                .height(1.dp)
                                .fillMaxWidth(0.9f)
                                .background(Color.Gray, shape = DottedShape(step = 3.dp))
                        )

                        Text(
                            text = "Value",
                            style = Typography.headlineSmall,
                            color = Color.White
                        )
                        Text(
                            text = "120.37 SAR",
                            style = Typography.headlineSmall,
                            color = Color.White
                        )

                    }


                }
            })
        


    }
        Spacer(modifier = Modifier.padding(20.dp))


}
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp)
    ) {
        Text(
            text = "Your rewards",
            style = Typography.headlineSmall,
            color = PrimaryColor
        )
       // Spacer(modifier = Modifier.padding(40.dp))

        Box(modifier = Modifier.clickable {

        }, ) {
            Row() {
                Text(
                    text = "See all",
                    style = Typography.headlineSmall,
                    color = PrimaryColor
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "Arrow"
                )
            }
        }

    }

     Spacer(modifier = Modifier.padding(15.dp))


}


private data class DottedShape(
    val step: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val stepPx = with(density) { step.toPx() }
        val stepsCount = (size.width / stepPx).roundToInt()
        val actualStep = size.width / stepsCount
        val dotSize = Size(width = actualStep / 2, height = size.height)
        for (i in 0 until stepsCount) {
            addRect(
                Rect(
                    offset = Offset(x = i * actualStep, y = 0f),
                    size = dotSize
                )
            )
        }
        close()
    })
}


////////////////////////////////////////////////
/*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArbahyBottomSheet(navController: NavController) {
    data class BottomSheetItem(val title: String, val icon: ImageVector)

    val bottomSheetItems = listOf(
        BottomSheetItem(title = "Notification", icon = Icons.Default.Notifications),
        BottomSheetItem(title = "Mail", icon = Icons.Default.MailOutline),
        BottomSheetItem(title = "Scan", icon = Icons.Default.Search),
        BottomSheetItem(title = "Edit", icon = Icons.Default.Edit),
        BottomSheetItem(title = "Favorite", icon = Icons.Default.Favorite),
        BottomSheetItem(title = "Settings", icon = Icons.Default.Settings)
    )

    //Lets define bottomSheetScaffoldState which will hold the state of Scaffold
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Expanded)
    )
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.Expanded }
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
        sheetContent = {
            //Ui for bottom sheet
            Column(
                content = {

Card() {
    
}
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)

                    //.background(Color(0xFF6650a4))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF8E2DE2),
                                Color(0xFF4A00E0)
                            )
                        ),
                        // shape = RoundedCornerShape(cornerRadius)
                    )
                    .padding(16.dp),

                )
        },
        sheetPeekHeight = 0.dp,

    ) {

        //Add button to open bottom sheet
        */
/*Column(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier
                    .padding(20.dp),
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                }
            ) {
                Text(
                    text = "Click to show Bottom Sheet"
                )
            }
        }*//*

    }
}*/
