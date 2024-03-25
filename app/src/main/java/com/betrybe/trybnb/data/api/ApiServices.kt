package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiServices {
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json")
    @POST("auth")
    suspend fun authLogin(
        @Body loginRequest: Login
    ): Response<Any>
}