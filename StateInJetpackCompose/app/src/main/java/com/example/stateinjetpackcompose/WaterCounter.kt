package com.example.stateinjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(vertical = 24.dp, horizontal = 16.dp)) {
        var count = 10
        Text(
            text = "You've had $count glasses.",
        )
        Spacer(modifier.height(16.dp))
        Button(
            onClick = { count++ }
        ) {
            Text(text = "Add one")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    StateInJetpackComposeTheme {
        WaterCounter()
    }
}