/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Home() {
    var themeState by remember { mutableStateOf(false) }

    MyTheme(darkTheme = themeState) {
        MyApp(onDarkThemeToggled = { themeState = !themeState })
    }
}

@Composable
fun MyApp(onDarkThemeToggled: () -> Unit) {
    Scaffold(
        topBar = {
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
        }
    ) {
        Surface { // color = MaterialTheme.colors.background
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
