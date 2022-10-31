package com.example.productlist

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kr.components.ui.theme.PrimaryColor

@Composable
fun ProductListScreen(navController: NavController) {

    Box(
            modifier = Modifier.padding(top=32.dp, start = 22.dp,end=22.dp, bottom = 32.dp)


    ) {

        LazyVerticalGrid(
          state =   rememberLazyGridState(),
            columns = GridCells.Fixed(2),
            userScrollEnabled = true,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .scrollable(rememberLazyGridState(), orientation = Orientation.Vertical),
            content = { items(7) { it-> ProductListItem()}
            }


            // contentPadding = PaddingValues(10.dp)
        )
    }

}


