package com.example.stateinjetpackcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WellnessTaskItem(
    task: String,
    onClose: () -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = task,
            modifier = modifier
                .padding(start = 16.dp)
                .weight(1f)
        )
        Checkbox(checked, onCheckedChange)
        IconButton(onClick = onClose) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}
@Composable
fun WellnessTaskItem(
    task: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }
        WellnessTaskItem(
            task = task,
            checked = checkedState,
            onClose = onClose,
            onCheckedChange = { newValue -> checkedState = newValue },
            modifier = modifier
        )
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    StateInJetpackComposeTheme {
        WellnessTaskItem("Task example", {})
    }
}