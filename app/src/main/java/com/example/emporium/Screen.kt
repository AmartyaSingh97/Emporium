package com.example.emporium

sealed class Screen(val route : String){
    object MarketPlaceScreen : Screen("marketplace_screen")
    object ProfileScreenNewUser : Screen("profile_screen_new_user")

}
