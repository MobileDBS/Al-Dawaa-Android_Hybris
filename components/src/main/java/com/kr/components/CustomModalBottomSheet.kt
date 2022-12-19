package com.kr.components
import PrimaryColor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch


@Composable
@ExperimentalMaterialApi
fun CustomModalBottomSheet(navController: NavController) {

    val list = listOf("Liked products" ,"Makeup" , "Create new")
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Expanded
    )

    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetState = modalBottomSheetState,
        sheetContent = {
                Column(modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Text(text = "Save to")

                    Divider(color = Color.LightGray, thickness = 1.dp)

                    LazyColumn {
                        items(list) { list ->
                            ListItem(
                                text = { Text(list) },
                            )
                        }
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            navController.navigate("CustomModalBottomSheet2")

                        } ,
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