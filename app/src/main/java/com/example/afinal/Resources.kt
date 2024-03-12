package com.example.afinal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.filled.CommentBank
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourcesScreen(navController: NavController) {
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
            Resources(paddingValues = paddingValues)

        }
    }
}

@Composable
fun Resources(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 72.dp, end = 8.dp, bottom = 4.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            item {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "HelpLine",
                            style = MaterialTheme.typography.headlineMedium

                        )
                        Text(text = "Vandrevala Foundation:  9999 666 555")
                        Text(text = "iCALL:  022-25521111, +91-9152987821")
                        Text(text = "Connecting Trust: +91-9922001122, +91-9922004305")
                        Text(text = "Mann Talks +91-8686139139")

                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
            }

            item {
                Card(modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Meditation",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text =
                            "Parts of meditation – \n" +
                                    "Each type of meditation may include certain features to help you meditate. These may vary depending on whose guidance you follow or who's teaching a class. Some of the most common features in meditation include:\n\n" +
                                    "    • Focused attention. Focusing your attention is one of the most important elements of meditation.\n\n" +
                                    "Focusing your attention is what helps free your mind from the many things that cause stress and worry. You can focus your attention on things such as a certain object, an image, a mantra or even your breathing.\n\n" +
                                    "    • Relaxed breathing. This technique involves deep, even-paced breathing using the muscle between your chest and your belly, called the diaphragm muscle, to expand your lungs. The purpose is to slow your breathing, take in more oxygen, and reduce the use of shoulder, neck and upper chest muscles while breathing so that you breathe better.\n\n" +
                                    "    • A quiet setting. If you're a beginner, meditation may be easier if you're in a quiet spot. Aim to have fewer things that can distract you, including no television, computers or cellphones.\n\n" +
                                    "As you get more skilled at meditation, you may be able to do it anywhere. This includes high-stress places, such as a traffic jam, a stressful work meeting or a long line at the grocery store. This is when you can get the most out of meditation.\n\n" +
                                    "    • A comfortable position. You can practice meditation whether you're sitting, lying down, walking, or in other positions or activities. Just try to be comfortable so that you can get the most out of your meditation. Aim to keep good posture during meditation.\n\n" +
                                    "    • Open attitude. Let thoughts pass through your mind without judging them.\n",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
            }

            item {
                Card(modifier = Modifier.fillMaxSize()) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            text = "Outdoor Activities",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text =
                                    "    1. Nature Walks/Hiking: Spending time in nature, whether it's a leisurely walk through a local park or a more rigorous hike in the mountains, can have a calming effect on the mind. The fresh air, natural scenery, and gentle exercise can help reduce stress and anxiety.\n" +
                                    "    2. Cycling: Cycling is not only a great form of exercise but also an excellent way to clear your mind and reduce anxiety. Explore bike paths, trails, or scenic routes in your area to enjoy the sights and sounds of nature while getting some physical activity.\n" +
                                    "    3. Gardening: Spending time tending to a garden can be therapeutic and calming. Whether you have a small balcony garden or a larger plot of land, gardening allows you to connect with nature, focus on the present moment, and enjoy the satisfaction of nurturing living plants.\n" +
                                    "    4. Photography: Taking up photography as a hobby can encourage you to explore new outdoor locations and appreciate the beauty of your surroundings. Whether you're capturing landscapes, wildlife, or everyday"
                        , modifier = Modifier.padding(8.dp))
                        Spacer(modifier = Modifier.padding(64.dp))
                    }
                }

            }
        }
    }
}