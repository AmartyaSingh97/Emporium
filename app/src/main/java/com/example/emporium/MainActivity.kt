package com.example.emporium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.emporium.data.NFT
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
            MarketPlaceScreen()
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
                .background(brush)
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
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Button),
                    ) {
                        androidx.compose.material3.Text("Connect Wallet",
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
                        onClick = onContinueClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = Btn2.copy(0.3f)),
                    ) {
                        androidx.compose.material3.Text("Enter Marketplace",
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


@Composable
fun MarketPlaceScreen() {
    val (value, onValueChange) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush),
        horizontalAlignment = Alignment.CenterHorizontally,
        ){

            Box(
              modifier = Modifier
                  .size(400.dp, 300.dp)
                  .padding(15.dp)
            ){

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        TextField(
                            value = value,
                            onValueChange = onValueChange,
                            textStyle = TextStyle(
                                color = Color.Gray,
                                fontSize = 12.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Normal,
                            ),

                            leadingIcon = { Icon(painter = painterResource(
                                id = R.drawable.e_logo)
                                , null, tint = Color.Gray) },
                            modifier = Modifier
                                .background(
                                    Color(0xFFADEBEC).copy(0.05f),
                                    RoundedCornerShape(12.dp)
                                ).size(300.dp,50.dp).defaultMinSize(minHeight = 50.dp),


                            trailingIcon = {
                                Icon(
                                    Icons.Filled.Search,
                                    null,
                                    tint = Color.Gray,
                                    modifier = Modifier.clickable { /*Click Action*/ })
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                backgroundColor = Color.Transparent,
                                cursorColor = Color.DarkGray
                            )
                        )
                         Image(
                             painter = painterResource(id=R.drawable.__icon__user_circle_plus_),
                                contentDescription = "Vector",
                             modifier = Modifier.size(32.dp,32.dp)
                         )
                    }
                Box(
                    modifier = Modifier.align(Alignment.Center).fillMaxWidth()
                        .height(150.dp).padding(top = 20.dp, start = 10.dp,end=10.dp)
                ){
                    Text(
                            text = "Welcome to",
                            color = Color.White,
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Normal,),
                        modifier = Modifier.align(Alignment.TopStart))
                    
                    Text(
                        text = "Emporium \uD83D\uDC4B",
                        color = Color.White,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 34.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,),
                        modifier = Modifier.align(Alignment.TopStart)
                            .padding(top = 20.dp))

                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xff51c4c6)),
                        modifier = Modifier
                            .width(width = 53.dp)
                            .height(height = 20.dp).align(Alignment.CenterEnd),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.vector2),
                            contentDescription = "Vector",
                            modifier = Modifier
                                .width(width = 11.dp)
                                .height(height = 7.dp))
                        Spacer(
                            modifier = Modifier
                                .width(width = 5.dp))
                        Text(
                            text = "Filter",
                            color = Color(0xff091019),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 9.sp))
                    }
                }





                }
            }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NFTCard(nft : NFT) {
    Card(
        modifier = Modifier
            .width(width = 319.dp)
            .height(height = 141.dp)
            .padding(all = 13.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color(0xffADEBEC).copy(alpha = 0.07f)),
    ){
            CardContent(
                name = nft.name,
                price = nft.price,
                imageUrl = nft.imageUrl,
                owner = nft.owner,
                createdDate = nft.createdDate)
     }
}

@Composable
private fun CardContent(
    name: String, price: String, imageUrl: String, owner : String, createdDate: String
){
    Row( modifier = Modifier
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
        .fillMaxWidth()){
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = "NFT Image",
                modifier = Modifier
                    .size(115.dp, 115.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .padding(13.dp),
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = name,
                    color = Color(0xffFFFFFF),
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "By $owner",
                    color = Color(0xffFFFFFF).copy(alpha = 0.25f),
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    text = "Created $createdDate",
                    color = Color(0xffFFFFFF).copy(alpha = 0.25f),
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp, bottom = 1.dp)
                ){

                    Image(
                        painter = painterResource(id = R.drawable.flow_logo),
                        contentDescription = "Flow Logo",
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                            .padding(top = 5.dp)
                    )
                    Text(
                        text = price,
                        color = Color(0xffFFFFFF),
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 5.dp,top = 4.dp)
                    )

                    Button(
                        modifier = Modifier
                            .height(30.dp)
                            .width(100.dp)
                            .padding(start = 13.dp),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Button),
                    ) {
                        androidx.compose.material3.Text("Buy Now",
                            color = BtnText,
                            fontSize = 11.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }


            }
    }
}

@Preview(showBackground = true)
@Composable
fun MarketplacePreview() {
    EmporiumTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            MarketPlaceScreen()
        }
    }
}

@Preview(showBackground = true, widthDp = 319, heightDp = 141,
    backgroundColor = R.color.black.toLong())
@Composable
fun NFTCardPreview() {
    EmporiumTheme{
        Surface(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF070E16))) {
            NFTCard(nft = NFT("069069", "The Panda",
                "https://picsum.photos/200", "https://picsum.photos/200",
                "0.69", "Sanidhya", "0x123456789",
                "April 2022", "India",   "5"))
        }
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
val Btn2 = Color(0xFFFFFFFF)

