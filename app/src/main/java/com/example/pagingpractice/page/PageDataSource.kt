package com.example.pagingpractice.page

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.pagingpractice.Api.RetrofitRepository
import com.example.pagingpractice.User
import com.example.pagingpractice.UserListBean
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PageDataSource(private val scope: CoroutineScope) :
    PageKeyedDataSource<Int, User>() {

    private val retrofitRepository = RetrofitRepository()


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        scope.launch {

            val result = retrofitRepository.getListForPage(1).users

            callback.onResult(result!!, 1, 2 )


            Log.d("loadInitial", "$result")
        }

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

        scope.launch {

            val result = retrofitRepository.getListForPage(params.key).users
            callback.onResult(result!!, params.key)

            Log.d("loadAfter", "$result")
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        scope.launch {

            val result = retrofitRepository.getListForPage(params.key).users
            val responseItems = result
            val key = if (params.key > 1) params.key - 1 else 0
            responseItems.let {
                callback.onResult(responseItems!!, key)
            }


            Log.d("loadBefore", "$result")
        }

    }
}