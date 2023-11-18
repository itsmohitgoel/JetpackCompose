package com.example.firstcompose.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstcompose.R
import com.example.firstcompose.viewmodels.MainViewModel

@Composable
fun CategoryScreen(onClick: (category: String) -> Unit) {
    val viewModel: MainViewModel = hiltViewModel()
    val categories: State<Set<String>> = viewModel.categories.collectAsState()

    if (categories.value.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Loading...", style = MaterialTheme.typography.displayLarge)
        }
    } else {
        CategoryGrid(data = categories.value, onClick)
    }

}

@Composable
private fun CategoryGrid(data: Set<String>, onClick: (category: String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(data.toList()) { category ->
            CategoryItem(category = category, onClick)
        }
    }
}

@Composable
fun CategoryItem(category: String, onClick: (category: String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFEEEEEE))
            .paint(
                painter = painterResource(id = R.drawable.ic_background_grid_item),
                contentScale = ContentScale.Crop
            )
            .clickable {
                onClick(category)
            },
        contentAlignment = Alignment.BottomCenter
    ) {

        Text(
            text = category,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
