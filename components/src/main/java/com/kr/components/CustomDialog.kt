package com.kr.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomDialog(
    modifier: Modifier = Modifier,
    title: String,
    description: String? = null,
    onRemoveHeadFromQueue: () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onRemoveHeadFromQueue()
        },
        title = {
            Text(
                text = title
            )
        },
        text = {
            if (description != null) {
                Text(text = description)
            }
        },
        buttons = {}
    )
}
