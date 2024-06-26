package com.example.starbucks.ui.pages.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.StarbucksTheme
import com.example.starbucks.data.MenuRepository
import com.example.starbucks.ui.components.MenuCard
import com.example.starbucks.ui.components.TextFieldInput

@Composable
fun MenuScreen() {
    val (search, setSearch) = rememberSaveable {
        mutableStateOf("")
    }

    val menu = MenuRepository.drinks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = "Welcome \uD83D\uDC4B",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Let's order and enjoy your order now.",
            fontSize = 14.sp
        )
        TextFieldInput(
            modifier = Modifier.fillMaxWidth(),
            value = search,
            onValueChange = setSearch,
            labelText = "Type Something...",
            leadingIcon = Icons.Filled.Search
        )
        Spacer(modifier = Modifier.size(20.dp))
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(150.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(menu) { photo ->
                    MenuCard(menu = photo)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MenuScreenPreview() {
    StarbucksTheme {
        MenuScreen()
    }
}