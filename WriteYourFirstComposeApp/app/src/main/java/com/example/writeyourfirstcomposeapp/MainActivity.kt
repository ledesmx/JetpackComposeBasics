package com.example.writeyourfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
    var showOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier) {
        if (showOnboarding) {
            OnboardingScreen(onContinueClicked = { showOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
fun Greetings(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
    ) {
//        val names = listOf("Android", "World", "Compose", "Kotlin", "Rust")
        val names: List<String> = List(1000) { "$it" }
        LazyColumn {
            items(items = names) { name ->
                Greeting(name = name)
            }

        }
//        Column {
//            for (name in names) {
//                Greeting(name = name)
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = rememberSaveable { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 54.dp else 22.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(horizontal = 6.dp, vertical = 3.dp)
    ) {
        Row(
            modifier = modifier.padding(
                bottom = extraPadding,
                start = 8.dp,
                top = 22.dp,
                end = 8.dp
            )
        ) {
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
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the basics Codelab!")
        Button(
            onClick = onContinueClicked,
            modifier = modifier.padding(top = 33.dp)
        ) {
            Text("Continue")
        }
    }
}

@Preview()
@Composable
fun MyAppPreview() {
    WriteYourFirstComposeAppTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingScreenPreview() {
    WriteYourFirstComposeAppTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview
@Composable
fun GreetingsPreview() {
    WriteYourFirstComposeAppTheme {
        Greetings()
    }
}
