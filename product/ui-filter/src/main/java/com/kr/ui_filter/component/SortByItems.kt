package com.kr.ui_filter.component

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import com.kr.components.ui.theme.*

@ExperimentalMaterial3Api
@Composable
fun SortByItems(context: Context,
                label: String,
                selected: Boolean,
                onChipChange: (String) -> Unit) {


    //var selected by remember { mutableStateOf(false) }

    SuggestionChip(   modifier = Modifier
        .fillMaxWidth()
        .height(40.dp),

        onClick = { if (!selected) {
            onChipChange(label)
            Toast.makeText(context, "you choes $label", Toast.LENGTH_SHORT).show()
        }
        else{ onChipChange("") }
             },
        label = { Text(label) },
        shape = RoundedCornerShape(20.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
        labelColor = PrimaryColor,
        containerColor = if (selected) SecondaryColor else FilterChip),
        border = SuggestionChipDefaults.suggestionChipBorder(Color.Transparent)

        )




    }
