package com.kr.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SnackbarHostComponent(snackbarHostState: SnackbarHostState) {
    val (snackbarhostref) = createRefs()
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = {
            Snackbar(
                containerColor = Color.Black,
                action = {
                    Text(
                        text = snackbarHostState.currentSnackbarData?.visuals?.actionLabel ?: "",
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                snackbarHostState.currentSnackbarData?.dismiss()
                            },
                        style = androidx.compose.ui.text.TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                }
            ) {
                Text(text = snackbarHostState.currentSnackbarData?.visuals?.message ?: "")
            }
        },

        )

}

/*
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SnackbarHostComponents(snackbarHostState: SnackbarHostState) {
    //val (snackbarhostref) = createRefs()
    SnackbarHost(hostState = snackbarHostState,
        snackbar = {
            Snackbar(containerColor = Color.Yellow,
                action = {
                Text(text =
                snackbarHostState.currentSnackbarData?.visuals?.actionLabel ?: "",
                    modifier = Modifier
                        .padding(5.dp)
                        .clickable {
                            snackbarHostState.currentSnackbarData?.dismiss()
                        })
            }){}
        }
    )
    val scaffoldState_: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState_) {
        coroutineScope.launch {
            val snackbarResult = scaffoldState_.snackbarHostState.showSnackbar(
                message = "Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as a",
                actionLabel = "ok"
            )
            when (snackbarResult) {
                SnackbarResult.Dismissed -> Log.v("snack", " dismissed")
                SnackbarResult.ActionPerformed -> Log.v("snack", " action perform")
            }
        }
    }
}
*/

@Composable
fun SampleSnackbar(isShowing:Boolean,onHideSnackbar: () -> Unit){
if (isShowing){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val snackbar = createRef()
        Snackbar(modifier = Modifier.constrainAs(snackbar){
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
            action = {
            Text(text = "Hide",
                modifier = Modifier.clickable(
                    onClick = onHideSnackbar
                ),
                style = MaterialTheme.typography.bodySmall
            )
        }
        ) {
            Text(text = "Testttttttttttttttttttttttttttttttttt")
        }
    }
}
}