package com.example.stateinjetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    StatefullCounter(modifier)
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    StateInJetpackComposeTheme {
        WellnessScreen()
    }
}