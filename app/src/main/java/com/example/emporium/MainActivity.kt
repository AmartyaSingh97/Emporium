package com.example.emporium

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.example.emporium.graphql.GraphQLInstance
import com.example.emporium.navigation.NavGraph
import com.example.emporium.ui.theme.EmporiumTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmporiumTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
                post("clejzdra40000jn0v43lh3zgv")
            }
        }
    }
}
@OptIn(DelicateCoroutinesApi::class)
private fun post(appId: String){
//    val retrofit = GraphQLInstance.graphQLService
//    val paramObject = JSONObject()
//    paramObject.put("query", """
//        query nftModels($appId: ID) {
//          nftModels(appId: $appId, maxResults: 50) {
//            items {
//              id
//              title
//              description
//              nfts {
//                id
//              }
//              status
//              rarity
//              content {
//                files {
//                  url
//                  contentType
//                }
//              }
//            }
//            cursor
//          }
//        }
//    """)
    val queryString = """
        query nftModels($appId: ID) {
          nftModels(appId: $appId, maxResults: 50) {
            items {
              id
              title
              description
              nfts {
                id
              }
              status
              rarity
              content {
                files {
                  url
                  contentType
                }
              }
            }
            cursor
          }
        }
    """.trimIndent()
    val retrofit = GraphQLInstance.graphQLService
    val paramObject = JSONObject()
    paramObject.put("query", queryString)
     GlobalScope.launch {
         try{
             val response = retrofit.postDynamicQuery(paramObject.toString())
             val length = response.data.nftModels.items.size
             Log.d("Okay", "post: $length")
         }
         catch (e: Exception){
             Log.d("NOTOKAY", e.toString())
         }
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

