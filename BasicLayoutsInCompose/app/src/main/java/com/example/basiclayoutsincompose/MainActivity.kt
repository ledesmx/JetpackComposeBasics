package com.example.basiclayoutsincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiclayoutsincompose.ui.theme.BasicLayoutsInComposeTheme
import org.intellij.lang.annotations.JdkConstants

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

data class DrawableTextItem(val drawable: Int, val text: Int)
val alignYourBodyData = listOf(
    DrawableTextItem(
        drawable = R.drawable.ab1_inversions,
        text = R.string.ab1_inversions
    ),
    DrawableTextItem(
        drawable = R.drawable.ab2_quick_yoga,
        text = R.string.ab2_quick_yoga
    ),
    DrawableTextItem(
        drawable = R.drawable.ab3_stretching,
        text = R.string.ab3_stretching
    ),
    DrawableTextItem(
        drawable = R.drawable.ab4_tabata,
        text = R.string.ab4_tabata
    ),
    DrawableTextItem(
        drawable = R.drawable.ab5_hiit,
        text = R.string.ab5_hiit
    ),
    DrawableTextItem(
        drawable = R.drawable.ab6_pre_natal_yoga,
        text = R.string.ab6_pre_natal_yoga
    )
)
val favoriteCollectionsData = listOf(
    DrawableTextItem(
        drawable = R.drawable.fc1_short_mantras,
        text = R.string.fc1_short_mantras
    ),
    DrawableTextItem(
        drawable = R.drawable.fc2_nature_meditations,
        text = R.string.fc2_nature_meditations
    ),
    DrawableTextItem(
        drawable = R.drawable.fc3_stress_and_anxiety,
        text = R.string.fc3_stress_and_anxiety
    ),
    DrawableTextItem(
        drawable = R.drawable.fc4_self_massage,
        text = R.string.fc4_self_massage
    ),
    DrawableTextItem(
        drawable = R.drawable.fc5_overwhelmed,
        text = R.string.fc5_overwhelmed
    ),
    DrawableTextItem(
        drawable = R.drawable.fc6_nightly_wind_down,
        text = R.string.fc6_nightly_wind_down
    )
)

@Composable
fun App(modifier: Modifier = Modifier) {
    Surface(modifier) {
        SearchBar()
    }
}

@Composable
fun MySootheAppPortrait() {
    BasicLayoutsInComposeTheme {
        Scaffold(bottomBar = { BottomNavigation() }) { padding ->
            HomeScreen(modifier = Modifier.padding(padding))
        }
    }
}

@Composable
fun MySootheAppLandscape() {
    BasicLayoutsInComposeTheme {
        Surface {
            Row(horizontalArrangement = Arrangement.Start) {
                AppNavigationRail()
                HomeScreen()
            }
        }
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
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(R.string.align_your_body_title) {
            AlignYourBodyRow()
        }
        HomeSection(R.string.favorite_collections_title) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
        )
        content()
    }
}

@Composable
private fun AppNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(0.dp),
        containerColor = MaterialTheme.colorScheme.surfaceVariant
        ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = true,
                onClick = {},
                label = {
                    Text(stringResource(R.string.nav_home))
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                colors = NavigationRailItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
            Spacer(Modifier.height(24.dp))
            NavigationRailItem(
                selected = false,
                onClick = {},
                label = {
                    Text(stringResource(R.string.nav_home))
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                colors = NavigationRailItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
        }
    }
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            // TODO() Cambiar el color bg de selected
            selected = true,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.nav_home)
                )
            }
        )
        NavigationBarItem(
            selected = false,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.nav_profile)
                )
            },
        )
    }
}

@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(80.dp)
            )
        }
    }
}
@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int,
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(text),
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
//            bitmap = TODO(),
            contentDescription = null,
//            modifier = TODO(),
//            alignment = TODO(),
            contentScale = ContentScale.Crop,
//            alpha = TODO(),
//            colorFilter = TODO(),
//            filterQuality = TODO()
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
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
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
//        colors = TextFieldDefaults.colors(
//            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
//            focusedContainerColor = MaterialTheme.colorScheme.surface
//        ),
        placeholder = {
            Text(stringResource(R.string.search_placeholder))
        },
//        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
//        enabled = TODO(),
//        readOnly = TODO(),
//        textStyle = TODO(),
//        label = TODO(),
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
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    BasicLayoutsInComposeTheme {
        SearchBar()
    }
}

@Preview
@Composable
fun AlignYourBodyElementPreview() {
    BasicLayoutsInComposeTheme {
        AlignYourBodyElement(drawable = R.drawable.ab1_inversions, text = R.string.ab1_inversions)
    }
}

@Preview
@Composable
fun FavoriteCollectionCardPreview() {
    BasicLayoutsInComposeTheme {
        FavoriteCollectionCard(drawable = R.drawable.fc2_nature_meditations, text = R.string.fc2_nature_meditations)
    }
}

@Preview
@Composable
fun AlignYourBodyRowPreview() {
    BasicLayoutsInComposeTheme {
        AlignYourBodyRow()
    }
}

@Preview
@Composable
fun FavoriteCollectionsGridPreview() {
    BasicLayoutsInComposeTheme {
        FavoriteCollectionsGrid()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    BasicLayoutsInComposeTheme {
        HomeSection(R.string.align_your_body_title) {
            AlignYourBodyRow()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeScreenPreview() {
    BasicLayoutsInComposeTheme {
        HomeScreen()
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 280)
@Composable
fun HomeScreenSmallPreview() {
    BasicLayoutsInComposeTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun BottonNavigationPreview() {
    BasicLayoutsInComposeTheme {
        BottomNavigation()
    }
}

@Preview(
    heightDp = 360
)
@Composable
fun AppNavigationRailPreview() {
    BasicLayoutsInComposeTheme {
        AppNavigationRail()
    }
}

@Preview(
    name = "Landscape",
    widthDp = 640,
    heightDp = 360
)
@Composable
fun MySootheAppLandscapePreview() {
    MySootheAppLandscape()
}
@Preview(name = "Portrait")
@Composable
fun MySootheAppPortraitPreview() {
    MySootheAppPortrait()
}