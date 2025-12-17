package com.example.basiclayoutsincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiclayoutsincompose.ui.theme.BasicLayoutsInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicLayoutsInComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Surface(modifier) {
        SearchBar()
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BasicLayoutsInComposeTheme {
        App(Modifier.padding(11.dp))
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
//        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
//        enabled = TODO(),
//        readOnly = TODO(),
//        textStyle = TODO(),
//        label = TODO(),
//        placeholder = TODO(),
//        leadingIcon = TODO(),
//        trailingIcon = TODO(),
//        prefix = TODO(),
//        suffix = TODO(),
//        supportingText = TODO(),
//        isError = TODO(),
//        visualTransformation = TODO(),
//        keyboardOptions = TODO(),
//        keyboardActions = TODO(),
//        singleLine = TODO(),
//        maxLines = TODO(),
//        minLines = TODO(),
//        interactionSource = TODO(),
//        shape = TODO(),
//        colors = TODO()
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    BasicLayoutsInComposeTheme() {
        SearchBar()
    }
}