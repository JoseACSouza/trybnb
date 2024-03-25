package com.betrybe.trybnb.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitGetInstances {
    private var retrofit: Retrofit? = null

    fun getInstance(): ApiServices {
        if (retrofit == null) {
            val headerInterceptor = Interceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .build()
                chain.proceed(request)
            }
            val client = OkHttpClient.Builder().addInterceptor(headerInterceptor).build()
            retrofit = Retrofit.Builder().baseUrl("https://restful-booker.herokuapp.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit?.create(ApiServices::class.java)!!
    }
}