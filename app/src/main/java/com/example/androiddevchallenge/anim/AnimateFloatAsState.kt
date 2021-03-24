package com.example.androiddevchallenge.anim

import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.isFinished
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.remember

@Composable
fun animateFloatAsState(key: Any?, targetValue: Float): State<Float> {
    val animSpec = remember { spring<Float>(stiffness = Spring.StiffnessLow) }
    val animationState = remember(key) { AnimationState(targetValue) }

    LaunchedEffect(key, targetValue, animSpec) {
        animationState.animateTo(
            targetValue = targetValue,
            animationSpec = animSpec,
            sequentialAnimation = !animationState.isFinished
        )
    }
    return animationState
}
