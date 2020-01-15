package com.example.pagingpractice.Api

import com.google.gson.JsonObject

class RetrofitRepository {

    var client: ApiInterface = RetrofitClient().apiInterface


    suspend fun getListForPage(page:Int) = client.getList(page)

}