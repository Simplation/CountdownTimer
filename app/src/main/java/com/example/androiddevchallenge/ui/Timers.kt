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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

private val TIMER_ELEVATION = 8.dp

@Composable
fun Timers(currentText: String, nextText: String, factor: Float) {
    Box(contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Box {
                Timer(
                    text = nextText,
                    position = TimerPosition.TOP,
                    elevation = TIMER_ELEVATION
                )

                if (factor < 0.5F) {
                    val f = factor * 2F

                    Timer(
                        text = currentText,
                        position = TimerPosition.TOP,
                        elevation = TIMER_ELEVATION * f,
                        modifier = Modifier.graphicsLayer(
                            rotationX = -90F * f,
                            transformOrigin = TransformOrigin(pivotFractionX = 0.5F, pivotFractionY = 1F)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.requiredHeight(1.dp))

            Box {
                Timer(
                    text = currentText,
                    position = TimerPosition.BOTTOM,
                    elevation = TIMER_ELEVATION
                )

                if (factor >= 0.5F) {
                    val f = (1F - factor) * 2F

                    Timer(
                        text = nextText,
                        position = TimerPosition.BOTTOM,
                        elevation = TIMER_ELEVATION * f,
                        modifier = Modifier.graphicsLayer(
                            rotationX = 90F * f,
                            transformOrigin = TransformOrigin(pivotFractionX = 0.5F, pivotFractionY = 0F)
                        )
                    )
                }
            }
        }
    }
}
