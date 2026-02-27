package com.example.stateinjetpackcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    val count = 10
    Text(
        text = "You've had $count glasses.",
        modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    StateInJetpackComposeTheme {
        WaterCounter()
    }
}