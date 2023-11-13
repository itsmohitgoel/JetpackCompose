package com.example.firstcompose.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstcompose.R
import com.example.firstcompose.viewmodels.MainViewModel

@Composable
fun CategoryScreen() {
    val viewModel: MainViewModel = viewModel()
    val categories: State<Set<String>> = viewModel.categories.collectAsState()

    CategoryGrid(data = categories.value)

}

@Composable
private fun CategoryGrid(data: Set<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(data.toList()) { category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFEEEEEE))
            .paint(
                painter = painterResource(id = R.drawable.ic_background_grid_item),
                contentScale = ContentScale.Crop
            ),
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
