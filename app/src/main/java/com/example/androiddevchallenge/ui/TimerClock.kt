package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.anim.animateFloatAsState
import com.example.androiddevchallenge.utils.getTimeParts
import kotlin.math.ceil

@Composable
fun TimerClock(seconds: Int, endMillis: Long, events: TimerClockEvents) {
    val animatedSeconds by animateFloatAsState(key = endMillis, targetValue = seconds.toFloat())

    val currentSeconds = ceil(animatedSeconds).toInt()
    val nextSeconds = currentSeconds - 1
    val factor = currentSeconds.toFloat() - animatedSeconds
    val currentParts = getTimeParts(currentSeconds)
    val nextParts = getTimeParts(nextSeconds)

    Row {
        TimerSection(
            title = stringResource(R.string.hours),
            currentValue = currentParts.hours,
            nextValue = nextParts.hours,
            factor = if (currentParts.hours == nextParts.hours) 0F else factor,
            onIncrement = events.onHoursIncrement,
            onDecrement = events.onHoursDecrement
        )

        Spacer(modifier = Modifier.width(16.dp))

        TimerSection(
            title = stringResource(R.string.minutes),
            currentValue = currentParts.minutes,
            nextValue = nextParts.minutes,
            factor = if (currentParts.minutes == nextParts.minutes) 0F else factor,
            onIncrement = events.onMinutesIncrement,
            onDecrement = events.onMinutesDecrement
        )

        Spacer(modifier = Modifier.width(16.dp))

        TimerSection(
            title = stringResource(R.string.seconds),
            currentValue = currentParts.seconds,
            nextValue = nextParts.seconds,
            factor = if (currentParts.seconds == nextParts.seconds) 0F else factor,
            onIncrement = events.onSecondsIncrement,
            onDecrement = events.onSecondsDecrement
        )
    }
}

class TimerClockEvents(
    val onHoursIncrement: () -> Unit,
    val onHoursDecrement: () -> Unit,
    val onMinutesIncrement: () -> Unit,
    val onMinutesDecrement: () -> Unit,
    val onSecondsIncrement: () -> Unit,
    val onSecondsDecrement: () -> Unit,
)
