package com.kr.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kr.components.ui.theme.PrimaryColor
import kotlinx.coroutines.launch
@Composable
@ExperimentalMaterialApi
fun CustomModalBottomSheet(list: List<String>) {

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val modalBottomSheetScope = rememberCoroutineScope()


    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
                Column(modifier = Modifier.padding(24.dp)) {
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
                        onClick = { /*TODO*/ } ,
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
        Button(
            onClick = {
                modalBottomSheetScope.launch {
                    modalBottomSheetState.show()
                }
            },
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ) {
            Text("Click", fontSize = 20.sp, color = Color.Black)
        }

    }
}