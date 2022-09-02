package com.terranullius.tamshaemployees.compose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun getTranslationXAnim(index: Int): State<Float> {
    var translationXState by remember {
        mutableStateOf(if (index % 2 == 0) -1000f else 1000f)
    }

    val translationXAnimState = animateFloatAsState(targetValue = translationXState)

    LaunchedEffect(Unit) {
        if (translationXState < 0f) {
            while (translationXState < 0f) {
                translationXState = translationXState.plus(100f)
                delay(35L)
            }
        } else {
            while (translationXState > 0f) {
                translationXState = translationXState.minus(100f)
                delay(35L)
            }
        }
    }

    return translationXAnimState
}