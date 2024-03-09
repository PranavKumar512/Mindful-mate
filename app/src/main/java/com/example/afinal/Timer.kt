package com.example.afinal

import android.os.SystemClock.sleep
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun Timer() {
    var cycle by remember {
        mutableStateOf(0)
    }

    var breathIn by remember { mutableStateOf(0) }
    var holdIn by remember {
        mutableStateOf(0)
    }
    var breathOut by remember {
        mutableStateOf(0)
    }
    var text by remember {
        mutableStateOf("")
    }
    var time by remember {
        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        while (cycle < 5) {
            while (breathIn < 5) {
                delay(1.seconds)
                breathIn++
                time = "$breathIn"
                text = "Breath In"
            }
            while (holdIn < 2) {
                delay(1.seconds)
                holdIn++
                time = "$holdIn"
                text = "Hold"
            }
            while (breathOut < 5) {
                delay(1.seconds)
                breathOut++
                time = "$breathOut"
                text = "Breath Out"
            }
            cycle++
            breathIn = 0
            holdIn = 0
            breathOut = 0
        }

    }



    Text(
        text = time,
        style = MaterialTheme.typography.displayLarge,
    )
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge,

    )


}

@Preview(showBackground = true)
@Composable
fun show() {
    Timer()
}