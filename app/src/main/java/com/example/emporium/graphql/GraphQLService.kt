package com.example.emporium.graphql

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface GraphQLService {

    @Headers("Content-Type: application/json",
              "X-Niftory-API-Key: +s/Vy/ZycvXE3layY3xkJ1W4IObeWquBSb/P5XfuX+w=",
            "X-Niftory-Client-Secret: 46385be88da67fba8725615ac6951d16e81395b54366616a9a229d11667c1de8a12f548e113011f05b63f39ec5a92b9567ec75f3d16088c7a688127ebc241c96")
    @POST("/")
    suspend fun postDynamicQuery(@Body body: String): Response<String>
}