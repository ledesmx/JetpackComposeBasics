package com.example.stateinjetpackcompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                task = task.label,
                onClose = { onCloseTask(task) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview() {
    StateInJetpackComposeTheme {
        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list = list, onCloseTask = {})
    }
}

private fun getWellnessTasks() = List(30) {
        i -> WellnessTask(i, "Task # $i")
}
