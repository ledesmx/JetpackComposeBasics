package com.example.stateinjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    val list = remember { getWellnessTasks().toMutableStateList() }
    Column(modifier) {
        StatefullCounter()
        WellnessTasksList(
            list = list,
            onCloseTask = { task -> list.remove(task) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    StateInJetpackComposeTheme {
        WellnessScreen()
    }
}

private fun getWellnessTasks() = List(30) {
    i -> WellnessTask(i, "Task # $i")
}
