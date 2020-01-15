package com.example.pagingpractice.Api

import com.example.pagingpractice.DataResultBean
import com.example.pagingpractice.UserResponse
import com.google.gson.JsonObject
import retrofit2.http.*

interface ApiInterface {


    @GET("users")
    suspend fun getList(@Query("page") page: Int): DataResultBean


}
