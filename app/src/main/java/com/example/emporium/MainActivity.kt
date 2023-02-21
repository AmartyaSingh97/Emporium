package com.example.emporium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emporium.ui.theme.EmporiumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmporiumTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier) {
        if(shouldShowOnboarding){
            OnBoardingScreen(onContinueClicked={
                shouldShowOnboarding = false
            })
        }
        else{
            Greetings("Hello")
        }
    }
}
val brush = Brush.verticalGradient(listOf(Color(0xFF070E16), Color(0xFF0B141F)))

@Composable
fun OnBoardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier) {

        Column(
            modifier
                .fillMaxSize()
                .background(brush).padding(top=39.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {

            Box(
                modifier = Modifier
                    .size(300.dp, 180.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.e_logo),
                    contentDescription = "Emporium Logo",
                    modifier = modifier
                        .size(120.dp, 120.dp).align(Alignment.TopCenter).
                    padding(bottom = 10.dp),
                )
                Text(
                    text = "Emporium",
                    color = Color.White,
                    fontSize = 64.sp,
                    fontFamily = Oswald,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier
                        .align(Alignment.BottomCenter).padding(top=10.dp)
                )
            }


            Divider(color = Color.White, thickness = 1.dp,
                modifier = modifier
                    .padding(
                        top = 10.dp,
                        bottom = 20.dp
                    )
                    .width(153.dp))

            Text(
                text = "Flow based NFT Marketplace",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
            )

            Box(contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(id  = R.drawable.dotted_design),
                    contentDescription = "Dotted Design",
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(1500.dp)

                )

                Box(modifier = Modifier.padding(bottom = 100.dp).
                align(Alignment.BottomCenter)){

                    Button(
                        modifier = Modifier
                            .height(50.dp).width(230.dp),
                        onClick = onContinueClicked,
                        colors = ButtonDefaults.buttonColors(Button),
                    ) {
                        androidx.compose.material3.Text("Connect Wallet",
                            color = BtnText,
                            fontSize = 18.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }

            }
        }

}

@Composable
fun Greetings(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmporiumTheme {
        Greetings("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    EmporiumTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            OnBoardingScreen(onContinueClicked = {})
        }
    }
}
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

