package com.example.emporium.screens

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
import com.example.emporium.Oswald
import com.example.emporium.Poppins
import com.example.emporium.R
import com.example.emporium.ui.theme.EmporiumTheme


@Composable
fun ProfileScreenNewUser(){

    val (value, onValueChange) = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.emporium.brush)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 25.dp)
                .clip(
                    shape = RoundedCornerShape(
                        bottomEnd = 40.dp,
                        bottomStart = 40.dp
                    )
                )
                .background(color = Color(0xFFADEBEC).copy(alpha = 0.05f)),
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
                    placeholder = { Text(text = "Search Users", color = Color.Gray) },

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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(185.dp)
                    .align(Alignment.BottomCenter)
                    .padding(start = 23.dp, top = 23.dp),
            ){
                Image(
                    painter = painterResource(id = R.drawable.user_photo_big),
                    contentDescription = "User Photo",
                    modifier = Modifier
                        .size(115.dp, 115.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .align(Alignment.TopStart)
                )
                Text(
                    text = "Flow In",
                    style = TextStyle(
                        color = Color(0xFFFFFFFF),
                        fontSize = 20.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                    ),
                    modifier = Modifier
                        .padding(top = 10.dp, start = 13.dp)
                        .align(Alignment.TopCenter)
                )
                Text(
                    text = "To buy & sell NFTs with ease",
                    style = TextStyle(
                        color = Color(0xFFFFFFFF).copy(0.5f),
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier
                        .padding(top = 46.dp, end = 49.dp)
                        .align(Alignment.TopEnd)
                )
                Box(
                    modifier = Modifier
                        .size(220.dp, 100.dp)
                        .align(Alignment.BottomEnd)
                        .padding(top = 20.dp)
                ){
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF51c4c6)),
                        modifier = Modifier
                            .width(width = 100.dp)
                            .height(height = 40.dp)
                            .align(Alignment.TopStart)
                    ) {
                        Text(
                            text = "Sign Up",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = Color(0xFF091019),
                                fontSize = 12.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.SemiBold,)
                        )
                    }

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
            )
            Text(
                text="Emporium",
                style = TextStyle(
                    color = Color(0xFFFFFFFF).copy(0.5f),
                    fontSize = 28.sp,
                    fontFamily = Oswald,
                    fontWeight = FontWeight.Normal,
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 60.dp)
            )
            Text(
                text="Made with ❤ by Team BroCode <\\>",
                style = TextStyle(
                    color = Color(0xFFFFFFFF).copy(0.5f),
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    EmporiumTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            ProfileScreenNewUser()
        }
    }
}
