package com.example.pagingpractice

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.pagingpractice.Api.RetrofitRepository
import com.example.pagingpractice.page.DataSourceFactory
import com.example.pagingpractice.page.PageDataSource
import kotlinx.coroutines.launch

class ActivityViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()

    val userPagedList: LiveData<PagedList<User>>
    private var liveDataSource = MutableLiveData<PageDataSource>()


    init {
        val itemDataSourceFactory = DataSourceFactory(viewModelScope)
        liveDataSource.value = itemDataSourceFactory.userList.value

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(6)
            .build()

        userPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()

        Log.d("userPagedListViewModel", "$userPagedList")
    }


}
