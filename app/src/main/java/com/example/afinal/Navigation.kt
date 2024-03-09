package com.example.afinal

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "screen1") {
        composable("screen1"){
            UiWindow(navController)
        }
        composable("screen2"){
            ActivitiesScreen(navController)
        }
        composable("screen3"){
            ResourcesScreen(navController)
        }


    }
}