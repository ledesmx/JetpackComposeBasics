package com.example.writeyourfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.writeyourfirstcomposeapp.ui.theme.WriteYourFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WriteYourFirstComposeAppTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
    ) {
        val names = listOf("Android", "World", "Compose", "Kotlin", "Rust")
        Column {
            for (name in names) {
                Greeting(name = name)
            }
        }

//        Hola()
//        Letter()
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 54.dp else 22.dp
    Surface(color = MaterialTheme.colorScheme.primary, modifier = modifier.padding(horizontal = 6.dp, vertical = 3.dp)) {
        Row(modifier = modifier.padding(
            bottom = extraPadding,
            start = 8.dp,
            top = 22.dp,
            end = 8.dp
        )) {
            Text(
                text = "Hello $name!",
                modifier = modifier
                    .padding(horizontal = 42.dp, vertical = 4.dp)
                    .weight(1f)
            )
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(text = if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun Letter(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.tertiary) {
        Text(
            text = "H",
            modifier = modifier.padding(11.dp)
        )
    }
}

@Composable
fun Hola(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.error,
        modifier = modifier
    ) {
        Text(text = "Hola")
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    WriteYourFirstComposeAppTheme {
        MyApp()
    }
}
