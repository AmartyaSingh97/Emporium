package com.example.emporium.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.emporium.*
import com.example.emporium.R
import com.example.emporium.navigation.Screen
import com.example.emporium.ui.theme.EmporiumTheme

@Composable
fun OnBoardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Column(
        modifier
            .fillMaxSize()
            .background(com.example.emporium.brush)
            .padding(top = 39.dp),
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
                    .size(120.dp, 120.dp)
                    .align(Alignment.TopCenter)
                    .padding(bottom = 10.dp),
            )
            Text(
                text = "Emporium",
                color = Color.White,
                fontSize = 64.sp,
                fontFamily = Oswald,
                fontWeight = FontWeight.Normal,
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .padding(top = 10.dp)
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

            Box(modifier = Modifier
                .padding(bottom = 130.dp)
                .align(Alignment.BottomCenter)){

                Button(
                    modifier = Modifier
                        .height(50.dp)
                        .width(230.dp),
                    onClick = {
                    },
                    colors = ButtonDefaults.buttonColors(Button),
                ) {
                    Text("Connect Wallet",
                        color = BtnText,
                        fontSize = 18.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterVertically),
                    )
                }
            }
            Box(modifier = Modifier
                .padding(bottom = 60.dp)
                .align(Alignment.BottomCenter)){

                Button(
                    modifier = Modifier
                        .height(50.dp)
                        .width(230.dp),
                    onClick = {
                        navController.navigate(Screen.MarketPlaceScreen.route)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Btn2.copy(0.3f)),
                ) {
                    Text("Enter Marketplace",
                        color = BtnText,
                        fontSize = 18.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterVertically),
                    )
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    EmporiumTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            OnBoardingScreen(navController = rememberNavController())
        }
    }
}
