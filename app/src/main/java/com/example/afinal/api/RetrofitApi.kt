package com.example.afinal.api


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface  RetrofitApi {
    @POST("/chatbot")
    suspend fun postData(@Body dataModel: DataModel?): Response<String>
}


