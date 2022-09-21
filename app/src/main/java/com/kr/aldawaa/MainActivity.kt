package com.kr.aldawaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kr.aldawaa.ui.theme.AlDawaaHybrisTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlDawaaHybrisTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello00 $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlDawaaHybrisTheme {
        Greeting("Android")
    }
}



@Preview ()
@Composable
fun Draw(){

    AlertDialog(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = {
        },
        title = {
            Text(
                text = "Title one"
            )
        },
        text = {
                Text(text = "Description One")
        },
        confirmButton = {
                        Text(text = "Setting")
        } ,
        dismissButton = {
            Text(text = "Ok")

        },
    )



}
