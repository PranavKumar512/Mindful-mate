package com.example.afinal

import VideoPlayerCard
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.CommentBank
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.api.DataModel
import com.example.afinal.api.RetrofitApi
import com.example.afinal.ui.theme.FinalTheme
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    Navigation()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiWindow(
    navController: NavController
) {

    Scaffold(
    containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = { Text(text = "ZenZone", modifier = Modifier.padding(start = 16.dp)) },

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
        postData(paddingValues = paddingValues)

    }
}

@Composable
fun postData(
    paddingValues: PaddingValues,


    ) { // Marking Composable function as suspend
    val ctx = LocalContext.current

    val input = remember {
        mutableStateOf("")
    }
    val response = remember {
        mutableStateOf("")
    }
    val coroutineScope = rememberCoroutineScope()
    var hide by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Bottom
    ) {

        LazyColumn {
            item {
                if (!hide) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .fillMaxHeight()
//                                .align(Alignment.CenterHorizontally)
//                                .padding(48.dp),
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//
//                        }
                        Card(
                            modifier = Modifier
                                .size(200.dp)
                                .clip(shape = CircleShape),

                            ) {
                            VideoPlayerCard()
                        }
                        Spacer(modifier = Modifier.padding(10.dp))

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                elevation = CardDefaults.cardElevation(16.dp),
                                modifier = Modifier
                                    .size(150.dp)
                                    .clickable {
                                        input.value = "Feeling Sad"
                                        hide = true

                                        coroutineScope.launch {
                                            postDataUsingRetrofit(ctx, input, response)
                                        }

                                    },

                                ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.feelingsad),
                                            contentDescription = "Feeling Sad"
                                        )
                                        Text(
                                            text = "Feeling Sad",
                                            modifier = Modifier.padding(bottom = 2.dp)
                                                .align(Alignment.BottomCenter)

                                        )
                                    }
                                }
                            }
// 😞😫😡😄🤯
                            Card(
                                elevation = CardDefaults.cardElevation(24.dp),
                                modifier = Modifier
                                    .size(150.dp)
                                    .clickable {
                                        input.value = "Feeling bored"
                                        hide = true

                                        coroutineScope.launch {
                                            postDataUsingRetrofit(ctx, input, response)
                                        }
                                    },


                                ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.feelingbored),
                                            contentDescription = "Feeling Bored"
                                        )
                                        Text(
                                            text = "Feeling Bored",
                                            modifier = Modifier.padding(bottom = 2.dp)
                                                .align(Alignment.BottomCenter)

                                        )
                                    }

                                }
//                                Text(
//                                    text = "Feeling Bored",
//                                    modifier = Modifier.padding(bottom = 24.dp)
//
//                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(36.dp))
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                elevation = CardDefaults.cardElevation(16.dp),
                                modifier = Modifier
                                    .size(150.dp)
                                    .clickable {
                                        input.value = "Stressed Out"
                                        hide = true

                                        coroutineScope.launch {
                                            postDataUsingRetrofit(ctx, input, response)
                                        }
                                    },


                                ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.feelingsad),
                                            contentDescription = "Stressed Out"
                                        )
                                        Text(
                                            text = "Stressed Out",
                                            modifier = Modifier.padding(bottom = 2.dp)
                                                .align(Alignment.BottomCenter)

                                        )
                                    }
                                }
                            }

                            Card(
                                elevation = CardDefaults.cardElevation(16.dp),
                                modifier = Modifier
                                    .size(150.dp)
                                    .clickable {
                                        input.value = "Need Motivation"
                                        hide = true

                                        coroutineScope.launch {
                                            postDataUsingRetrofit(ctx, input, response)
                                        }
                                    },

                                ) {

                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.needmotivation),
                                            contentDescription = "Need Motivation",
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            text = "Need Motivation",
                                            modifier = Modifier.padding(bottom = 2.dp)
                                                .align(Alignment.BottomCenter)

                                        )
                                    }
                                }


                            }
                        }
                    }

                } else {
                    if (response.value == "") {
                        LoadingAnimation()
                    } else {

                        Card(
                            elevation = CardDefaults.cardElevation(8.dp),
                            modifier = Modifier.padding(16.dp),

                            ) {

                            ChatTypingAnimation(messages = response.value)
                        }
                    }
                }
            }
            item {
                Spacer(
                    modifier = Modifier.size(8.dp)
                )
            }
            item {

                OutlinedTextField(

                    value = input.value,
                    onValueChange = {
                        input.value = it
                        hide = true


                    },
                    label = {
                        Text(text = "Ask here")
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                postDataUsingRetrofit(ctx, input, response)
                            }

                        }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Send"
                            )
                        }
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 16.dp, end = 8.dp, bottom = 64.dp),
                    shape = RoundedCornerShape(24.dp),


                    )
            }

        }


    }
}


private suspend fun postDataUsingRetrofit(
    ctx: Context,
    input: MutableState<String>,
    result: MutableState<String>
) {
    val url = "http://192.168.172.11:3000"

    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        )
        .build()

    val retrofitApi = retrofit.create(RetrofitApi::class.java)

    val dataModel = DataModel(input.value)


    try {
        val response: Response<String> = retrofitApi.postData(dataModel)

        if (response.isSuccessful) {
            Toast.makeText(ctx, "RESPONSE", Toast.LENGTH_SHORT).show()
            val responseBody: String? = response.body()
            result.value = " $responseBody"
            if (result.value != "") {
                input.value = ""
            }

        } else {
            result.value = "Error found is : ${response.errorBody()?.string()}"
        }
    } catch (e: Exception) {
        result.value = "Error: Failed To Connect to Server"
    }
}

@Preview(showBackground = true)
@Composable
fun Show() {
//    UiWindow()
}