package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val TIMER_WIDTH = 96.dp
private val TIMER_HEIGHT = 36.dp
private val BACKGROUND_COLOR_LIGHT = Color(red = 0xC0, green = 0xC0, blue = 0xC0)
private val BACKGROUND_COLOR_DARK = Color(red = 0x20, green = 0x20, blue = 0x20)
private val TOP_FLAP_SHAPE = RoundedCornerShape(4.dp, 4.dp, 0.dp, 0.dp)
private val BOTTOM_FLAP_SHAPE = RoundedCornerShape(0.dp, 0.dp, 4.dp, 4.dp)

@Composable
fun Timer(
    text: String,
    position: TimerPosition,
    elevation: Dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.requiredSize(width = TIMER_WIDTH, height = TIMER_HEIGHT),
        elevation = elevation,
        shape = when (position) {
            TimerPosition.TOP -> TOP_FLAP_SHAPE
            TimerPosition.BOTTOM -> BOTTOM_FLAP_SHAPE
        }
    ) {
        Box(
            modifier = Modifier.background(
                if (MaterialTheme.colors.isLight) BACKGROUND_COLOR_LIGHT
                else BACKGROUND_COLOR_DARK
            ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontFamily = FontFamily.SansSerif,
                fontSize = 64.sp,
                modifier = Modifier
                    .requiredWidth(IntrinsicSize.Min)
                    .requiredHeight(IntrinsicSize.Min)
                    .run {
                        when (position) {
                            TimerPosition.TOP -> offset(y = TIMER_HEIGHT / 2)
                            TimerPosition.BOTTOM -> offset(y = TIMER_HEIGHT / -2)
                        }
                    }
                    .offset(y = (-2).dp)
            )
        }
    }
}

enum class TimerPosition {
    TOP, BOTTOM
}
