package com.example.starbucks.ui.pages.claimReward

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.StarbucksTheme
import com.example.starbucks.data.RewardRepository
import com.example.starbucks.ui.components.RewardCard

@Composable
fun RewardScreen() {
    val rewards = RewardRepository.rewards

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = "Reward Options",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Claim your reward now!",
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn {
            items(rewards) { reward ->
                RewardCard(
                    reward = reward,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RewardScreenPreview() {
    StarbucksTheme {
        RewardScreen()
    }
}