package com.example.emporium

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.emporium.navigation.Screen

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingScreen.route)
    {
        composable(route = Screen.ProfileScreenNewUser.route){
            ProfileScreenNewUser()
        }
        composable(route = Screen.MarketPlaceScreen.route){
            MarketPlaceScreen(navController = navController)
        }
        composable(route = Screen.OnBoardingScreen.route){
            OnBoardingScreen(navController = navController)
        }
    }
}