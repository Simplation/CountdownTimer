package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

@Composable
fun TimerSection(
    title: String,
    currentValue: Int,
    nextValue: Int,
    factor: Float,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, fontSize = 20.sp)

        IconButton(onClick = onIncrement) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "$title increment button!"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Timers(
            currentText = currentValue.toString().padStart(2, '0'),
            nextText = nextValue.toString().padStart(2, '0'),
            factor = factor
        )

        Spacer(modifier = Modifier.height(8.dp))

        IconButton(onClick = onDecrement) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "$title decrement button!"
            )
        }
    }
}

@Preview
@Composable
fun PreviewTimerSection() {
    TimerSection(
        title = stringResource(id = R.string.app_title),
        currentValue = 10,
        nextValue = 20,
        factor = 0F,
        onIncrement = { /*TODO*/ },
        onDecrement = { /*TODO*/ })
}
