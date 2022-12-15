package com.kr.components
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor
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

        // on below line we are creating a text
        Text(text = "Floating Action Buttons in Android\nJetpack Compose",
            color = WhiteColor,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Simple Floating Action Button", Toast.LENGTH_SHORT).show()
            },
           backgroundColor = WhiteColor,
            contentColor = Color.Unspecified
        ) {
            Icon(painter = painterResource(R.drawable.ic_chatbot), "")
        }

        Spacer(modifier = Modifier.height(20.dp))
        FloatingActionButton(

            onClick = {
                Toast.makeText(context, "Square Floating Action Button", Toast.LENGTH_SHORT).show()
            },
             shape = RoundedCornerShape(20.dp),
            backgroundColor = WhiteColor,
             contentColor = Color.Unspecified
        ) {
          Icon(painter = painterResource(R.drawable.ic_chatbot), "")
        }
        Spacer(modifier = Modifier.height(20.dp))
         ExtendedFloatingActionButton(
            text = { Text(text = "Speak to a pharmacist" ,
                color = PrimaryColor)
                   },
            onClick = {
                Toast.makeText(context, "Extended Floating Action Button", Toast.LENGTH_SHORT).show()
                      },
             backgroundColor = WhiteColor,
             contentColor = Color.Unspecified,
           icon = { Icon(painter = painterResource(R.drawable.ic_chatbot), "") }
        )
    }



    Spacer(modifier = Modifier.height(20.dp))

    FloatingActionButton(onClick = {
        Toast.makeText(
            context,
            "You clicked floating action button with circular shape....",
            Toast.LENGTH_LONG
        ).show()
    }, content = {
        Column() {

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "image",
                tint = Color.White
            )

            Text(text = ("hiiiii"))
        }

    }, backgroundColor = Color.Blue)

}
