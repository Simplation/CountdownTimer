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

import android.os.SystemClock
import android.text.format.DateUtils
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.Math.max
import kotlin.math.ceil

@Composable
fun CountdownTimer(onDarkThemeToggled: () -> Unit, modifier: Modifier = Modifier) {
    var endTime by remember { mutableStateOf(SystemClock.uptimeMillis()) }
    var remainingSeconds by remember { mutableStateOf(0) }

    fun updateRemainingTime() {
        remainingSeconds = ceil(
            x = (endTime - SystemClock.uptimeMillis()).coerceAtLeast(0L).toFloat() / 1000F
        ).toInt()
    }

    fun addTime(millis: Long) {
        endTime = max(endTime, SystemClock.uptimeMillis()) + millis
        updateRemainingTime()
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Main) {
            while (true) {
                updateRemainingTime()
                delay(100L)
            }
        }
    }

    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        TimerClock(
            seconds = remainingSeconds,
            endMillis = endTime,
            events = TimerClockEvents(
                onHoursIncrement = { addTime(DateUtils.HOUR_IN_MILLIS) },
                onHoursDecrement = { addTime(-DateUtils.HOUR_IN_MILLIS) },
                onMinutesIncrement = { addTime(DateUtils.MINUTE_IN_MILLIS) },
                onMinutesDecrement = { addTime(-DateUtils.MINUTE_IN_MILLIS) },
                onSecondsIncrement = { addTime(DateUtils.SECOND_IN_MILLIS) },
                onSecondsDecrement = { addTime(-DateUtils.SECOND_IN_MILLIS) }
            )
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Preview
@Composable
fun PreviewCountdownTimer() {
    CountdownTimer(onDarkThemeToggled = { })
}
