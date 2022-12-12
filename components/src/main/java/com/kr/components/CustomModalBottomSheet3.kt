package com.kr.components
import android.view.ViewGroup
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
import kotlinx.coroutines.launch
@Composable
@ExperimentalMaterialApi
fun CustomModalBottomSheet3(
    navController: NavController) {

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Expanded
    )
    val coroutineScope = rememberCoroutineScope()




    val list = listOf(R.drawable.ic_wishlist_arm, R.drawable.ic_wishlist_apple,
        R.drawable.ic_wishlist_baby ,  R.drawable.image_1, R.drawable.ic_wishlist_brush
    , R.drawable.ic_wishlist_cloud , R.drawable.ic_wishlist_cream, R.drawable.ic_wishlist_eye ,
        R.drawable.ic_wishlist_face ,  R.drawable.ic_wishlist_hair)

    ModalBottomSheetLayout(
      sheetState  = modalBottomSheetState,
        sheetContent = {

                Column(modifier = Modifier.padding(16.dp)) {
                    Row() {
                        Text(text = "Select an icon  ")
                        Text(text = "Cancel")

                    }
                    Divider(color = Color.LightGray, thickness = 1.dp)

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4)
                    )
                    {
                        items(list) { list ->


                            Icon(
                                painter = painterResource(list),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )


                        }

                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {

                            coroutineScope.launch {
                                modalBottomSheetState.hide()
                            }

                        },
                        border = BorderStroke(2.dp, PrimaryColor),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryColor)
                    ) {
                        Text(text = "Submit")

                    }
                }
        },
        sheetShape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)

    ) {

    }
}