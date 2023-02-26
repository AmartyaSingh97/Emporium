package com.example.emporium.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.emporium.Poppins
import com.example.emporium.R
import com.example.emporium.model.datamodel.NFT
import com.example.emporium.ui.theme.EmporiumTheme

@Composable
fun NFTView(
    NFT: NFT,
) {

    val (value, onValueChange) = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.emporium.brush)
    ){
        Box(
            modifier = Modifier.fillMaxWidth().height(130.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.dp, start = 23.dp, end = 6.dp),
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
                    placeholder = { Text(text = "Search NFTs", color = Color.Gray) },

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
                    painter = painterResource(id= R.drawable.__icon__user_circle_plus_),
                    contentDescription = "Vector",
                    modifier = Modifier.size(32.dp,32.dp)
                )
            }
        }

        Box(
            modifier = Modifier.size(340.dp,750.dp).padding(bottom=20.dp).
            align(Alignment.BottomCenter).background(Color(0xFFADEBEC)
                .copy(0.07f),RoundedCornerShape(16.dp))
        ){
            Image(
                painter = painterResource(id = R.drawable.nft_photo),
                contentDescription = "NFT Photo",
                modifier = Modifier
                    .size(176.dp).clip(shape = RoundedCornerShape(12.dp)).
                    align(Alignment.TopCenter).padding(top=27.dp)
            )
            Text(
                text = NFT.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier.align(Alignment.TopCenter).padding(top=190.dp)
            )
            Text(
                text = "By ${NFT.owner}",
                style = TextStyle(
                    color = Color.White.copy(0.5f),
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                ),
                modifier = Modifier.align(Alignment.TopCenter).padding(top=230.dp)
            )
            Box(
                modifier = Modifier.align(Alignment.TopCenter).
                padding(top=288.dp,end=40.dp)
            ){
            Image(
                    painter = painterResource(id = R.drawable.flow_logo),
                    contentDescription = "Flow Logo",
                    modifier = Modifier
                        .size(33.dp, 33.dp)
                        .align(Alignment.Center)
                )}
            Text(
                text = NFT.price,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier.align(Alignment.TopCenter).
                padding(top=288.dp,start=60.dp)
            )
            Divider(
                color = Color.White.copy(alpha = 0.3f)
                , modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top=345.dp)
                    .height(1.dp).width(274.dp)
            )
            Text(
                text = NFT.description,
                style = TextStyle(
                    color = Color.White.copy(0.5f),
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.TopCenter).padding(top=370.dp).
                width(274.dp).height(63.dp)
            )


            Divider(
                color = Color.White.copy(alpha = 0.3f)
                , modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top=600.dp)
                    .height(1.dp).width(274.dp)
            )
            Box(
                modifier = Modifier.size(200.dp,80.dp).align(Alignment.BottomCenter)
            ){
                androidx.compose.material3.Button(
                    onClick = { },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF51c4c6)),
                    modifier = Modifier
                        .width(width = 170.dp)
                        .height(height = 38.dp)
                        .align(Alignment.TopCenter)
                ) {
                    Text(
                        text = "Login and Buy Now",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color(0xFF091019),
                            fontSize = 13.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                        )
                    )
                }

            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(580.dp),
        ){
            Image(
                painter = painterResource(id  = R.drawable.dotted_design),
                contentDescription = "Dotted Design",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1500.dp),
                alpha = 0.08f
            )}
    }

}

@Preview(showBackground = true)
@Composable
fun NFTPreview() {
    EmporiumTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            NFTView(NFT = NFT("069069", "The Panda",
                "The panda is one of the most favorite token" +
                        " for collectors. So what are you waiting for. Go grab it now"
                , "https://picsum.photos/200",
                "0.69", "Sanidhya", "0x123456789",
                "April 2022", "India",   "5"))
        }
    }
}