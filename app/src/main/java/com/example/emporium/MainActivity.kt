package com.example.emporium

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.example.emporium.navigation.NavGraph
import com.example.emporium.ui.theme.EmporiumTheme

class MainActivity : ComponentActivity() {

    private var key = ""
    var secret = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmporiumTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }

        val ai: ApplicationInfo = applicationContext.packageManager
            .getApplicationInfo(applicationContext.packageName, PackageManager.GET_META_DATA)

        key = ai.metaData["api_key"].toString()
        secret = ai.metaData["api_secret"].toString()
    }

    fun getKey() : String{
        return key
    }
    fun getSecret() : String{
        return secret
    }
}

val brush = Brush.verticalGradient(listOf(Color(0xFF070E16), Color(0xFF0B141F)))

val Poppins = FontFamily(
    Font(
        resId = R.font.poppins,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.poppins_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.poppins_bold,
        weight = FontWeight.Bold
    )
)

val Oswald = FontFamily(
    Font(
        resId = R.font.oswald,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.oswald_bold,
        weight = FontWeight.Bold
    )
)


val Button = Color(0xFF51C4C6)
val BtnText = Color(0xFF0A131D)
val Btn2 = Color(0xFFFFFFFF)

