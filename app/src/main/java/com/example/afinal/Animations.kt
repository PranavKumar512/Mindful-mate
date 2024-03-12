package com.example.afinal

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.min


@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier.padding(16.dp),
    circleSize: Dp = 8.dp,
    circleColor: Color = MaterialTheme.colorScheme.primary,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp
) {
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        0.0f at 0 using LinearOutSlowInEasing
                        1.0f at 300 using LinearOutSlowInEasing
                        0.0f at 600 using LinearOutSlowInEasing
                        0.0f at 1200 using LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    val circleValues = circles.map { it.value }
    val distance = with(LocalDensity.current) { travelDistance.toPx() }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        circleValues.forEach { value ->
            Box(
                modifier = Modifier
                    .size(circleSize)
                    .graphicsLayer {
                        translationY = -value * distance
                    }
                    .background(
                        color = circleColor,
                        shape = CircleShape
                    )
            )
        }
    }

}

@Composable
fun ChatTypingAnimation(messages: String, typingSpeed: Long = 20) {
    var currentCharacterIndex by remember { mutableStateOf(0) }
    var isTyping by remember { mutableStateOf(true) }

    LaunchedEffect(isTyping) {
        while (isTyping) {
            delay(typingSpeed)
            if (currentCharacterIndex < messages.length) {
                currentCharacterIndex++
            }
        }
    }

    val typedMessage = messages.substring(0, min(currentCharacterIndex, messages.length))

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Text(
            text = typedMessage,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth() ,
            style = MaterialTheme.typography.titleLarge

        )
        CursorBlinking()
    }
}


@Composable
fun CursorBlinking(modifier: Modifier = Modifier) {
    var cursorAlpha by remember { mutableStateOf(1f) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(500)
            cursorAlpha = if (cursorAlpha == 1f) 0f else 1f
        }
    }

    Box(
        modifier = modifier
            .width(2.dp)
            .fillMaxHeight()
            .background(Color.Black)
            .alpha(cursorAlpha)
    )
}

