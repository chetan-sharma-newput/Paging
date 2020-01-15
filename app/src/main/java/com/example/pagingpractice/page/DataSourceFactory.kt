package com.example.pagingpractice.page

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.pagingpractice.DataResultBean
import com.example.pagingpractice.User
import com.example.pagingpractice.UserListBean
import kotlinx.coroutines.CoroutineScope

class DataSourceFactory(private val scope: CoroutineScope): DataSource.Factory<Int, User>() {

     val userList=MutableLiveData<PageDataSource>()

    override fun create(): DataSource<Int, User> {

        val dataResultBean=PageDataSource(scope)
        userList.postValue(dataResultBean)
        return dataResultBean
    }



}