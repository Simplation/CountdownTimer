package com.example.androiddevchallenge.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.R

@Composable
fun Home() {
    var themeState by remember { mutableStateOf(false) }

    MyTheme(darkTheme = themeState) {
        MyApp(onDarkThemeToggled = { themeState = !themeState })
    }
}

@Composable
fun MyApp(onDarkThemeToggled: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_title))
            },
            actions = {
                IconButton(onClick = onDarkThemeToggled) {
                    Icon(
                        imageVector = if (MaterialTheme.colors.isLight) Icons.Default.DarkMode else Icons.Default.LightMode,
                        contentDescription = "Dark theme button"
                    )
                }
            }
        )
    }) {
        Surface() { // color = MaterialTheme.colors.background
            Card(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 20.dp),
                border = BorderStroke(color = Color.Black, width = Dp.Hairline),
                backgroundColor = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CountdownTimer(
                        onDarkThemeToggled = onDarkThemeToggled,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 20.dp)
                            .wrapContentSize()
                    )
                }
            }
        }
    }
}
