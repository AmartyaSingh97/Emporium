package com.example.emporium

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response


private var instance: ApolloClient? = null

fun apolloClient(context: Context): ApolloClient {
    if (instance != null) {
        return instance!!
    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthorizationInterceptor(context))
        .build()

    instance = ApolloClient.Builder()
        .serverUrl("https://api.staging.niftory.com/v1/graphql")
        .okHttpClient(okHttpClient)
        .normalizedCache(
            MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024))
        .build()

    return instance!!
}

private class AuthorizationInterceptor(val context: Context): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val key = MainActivity().getKey()
        val secret = MainActivity().getSecret()

        val request = chain.request().newBuilder()
            .addHeader("X-Niftory-API-Key",  key)
            .addHeader("X-Niftory-Client-Secret", secret)
            .build()

        return chain.proceed(request)
    }
}