package com.example.emporium.screens

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.emporium.BtnText
import com.example.emporium.Poppins
import com.example.emporium.R
import com.example.emporium.model.datamodel.NFT
import com.example.emporium.model.viewmodel.NftViewModel
import com.example.emporium.navigation.Screen
import com.example.emporium.ui.theme.EmporiumTheme

@Composable
fun MarketPlaceScreen(
    NftViewModel: NftViewModel = viewModel(),
    navController: NavController
) {
    val (value, onValueChange) = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.emporium.brush),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Box(
            modifier = Modifier
                .size(400.dp, 300.dp)
                .padding(15.dp)
        ){

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
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
                            RoundedCornerShape(80.dp)
                        )
                        .size(300.dp, 53.dp)
                        .defaultMinSize(minHeight = 53.dp),
                    placeholder = { Text(text = "Search", color = Color.Gray) },

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
                    modifier = Modifier
                        .size(32.dp, 32.dp)
                        .clickable(
                            enabled = true,
                            onClick = {
                                navController.navigate(Screen.ProfileScreenNewUser.route)
                            }
                        ),

                    )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp)
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
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 20.dp))

                Box(
                    modifier = Modifier
                        .width(53.dp)
                        .height(20.dp)
                        .align(Alignment.CenterEnd),

                    ){
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xff51c4c6)),
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center),
                        content = {
                            Text(
                                text = ""
                            )
                        }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vector2),
                        contentDescription = "Vector",
                        modifier = Modifier
                            .width(width = 11.dp)
                            .height(height = 9.dp)
                            .align(Alignment.CenterStart)
                            .padding(start = 5.dp))

                    Text(
                        text = "Filter",
                        style = TextStyle(
                            color = Color(0xff091019),
                            fontSize = 9.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(start = 10.dp))
                }
            }
        }

        Box(contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(id  = R.drawable.dotted_design),
                contentDescription = "Dotted Design",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1500.dp),
                alpha = 0.08f
            )
        }
        //   NftList(nfts =NftViewModel.nfts)

    }
}

@Composable
fun NftList(nfts : List<NFT>){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.emporium.brush),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(19.dp)
    ){
        this.items(items = nfts){ nft ->
            NFTCard(nft = nft)
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
            .background(color = Color(0xFFADEBEC).copy(alpha = 0.07f)),
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
                    colors = ButtonDefaults.buttonColors(com.example.emporium.Button),
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
            MarketPlaceScreen(navController = rememberNavController())
        }
    }
}

@Preview(showBackground = true, widthDp = 319, heightDp = 141,
    backgroundColor = 0xFF070E16, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun NFTCardPreview() {
    EmporiumTheme{
        Surface(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF070E16))) {
            NFTCard(nft = NFT("069069", "The Panda",
                "https://picsum.photos/200", "https://picsum.photos/200",
                "0.69", "Sanidhya", "0x123456789",
                "April 2022", "India",   "5")
            )
        }
    }
}
