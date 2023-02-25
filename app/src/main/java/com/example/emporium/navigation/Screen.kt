package com.example.emporium.navigation

sealed class Screen(val route : String){
    object MarketPlaceScreen : Screen("marketplace_screen")
    object ProfileScreenNewUser : Screen("profile_screen_new_user")
    object OnBoardingScreen : Screen("onboarding_screen")
    object NFTView : Screen("nft_view")
}
