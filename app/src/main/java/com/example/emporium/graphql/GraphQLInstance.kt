package com.example.emporium.graphql

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object GraphQLInstance {

    private const val BASE_URL: String = "https://api.staging.niftory.com/v1/graphql/"

    val graphQLService: GraphQLService by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build().create(GraphQLService::class.java)
    }
}