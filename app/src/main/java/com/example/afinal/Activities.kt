package com.example.afinal

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.filled.CommentBank
import androidx.compose.material.icons.filled.PauseCircleOutline
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivitiesScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Mindful mate", modifier = Modifier.padding(start = 16.dp)) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Go Back"
                            )
                        }

                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = { navController.navigate("screen1") },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.CommentBank,
                                contentDescription = "Ask"
                            )
                        })
                    NavigationBarItem(
                        selected = true,
                        onClick = { navController.navigate("screen2") },
                        icon = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.DirectionsRun,
                                contentDescription = "Ask"
                            )
                        })
                    NavigationBarItem(
                        selected = true,
                        onClick = { navController.navigate("screen3") },
                        icon = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.LibraryBooks,
                                contentDescription = "Ask"
                            )
                        })
                }
            }
        ) { paddingValues ->

            Activities(paddingValues = paddingValues)

        }
    }
}


@Composable
fun Activities(
    paddingValues: PaddingValues
) {

    var timerCall by remember {
        mutableStateOf(false)
    }
    val mContext = LocalContext.current

    val mMediaPlayer = MediaPlayer.create(mContext, R.raw.guitar)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.im4),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(2.dp))
                        .blur(4.dp)

                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Relaxing Sounds",
                        style = MaterialTheme.typography.displayLarge,
                        color = Color(0xFFD5DBE0)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        IconButton(
                            onClick = {
                                mMediaPlayer.start()

                            },
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(50.dp)
                                .padding(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.PlayCircleOutline,
                                contentDescription = "Play",
                                modifier = Modifier.size(64.dp),
                                tint = Color(0xFFD5DBE0)
                            )

                        }
                        IconButton(
                            onClick = {
                                mMediaPlayer.pause()

                            },
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(50.dp)
                                .padding(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.PauseCircleOutline,
                                contentDescription = "Pause",
                                modifier = Modifier.size(64.dp),
                                tint = Color(0xFFD5DBE0)
                            )

                        }

                    }


                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp)
        ) {
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.img3),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(2.dp))
                        .blur(4.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    if (!timerCall){
                        Text(text = "Calm mind",
                            style = MaterialTheme.typography.displayLarge,
                            color = Color(0xFFD5DBE0))



                    }else{
                        Timer()
                    }
                    IconButton(
                        onClick = {
                            timerCall = !timerCall
                        },
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(50.dp)
                            .padding(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayCircleOutline,
                            contentDescription = "Play",
                            modifier = Modifier.size(64.dp),
                            tint = Color(0xFFD5DBE0)

                        )

                    }
                }
            }


        }
    }
}





