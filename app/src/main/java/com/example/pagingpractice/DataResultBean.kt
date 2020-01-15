package com.example.pagingpractice

import com.google.gson.annotations.SerializedName

data class DataResultBean(var data: List<UserListBean>)

//@field:SerializedName("data")
//var users: List<User>? = null
//@field:SerializedName("page")
//var page: Int = 0
//@field:SerializedName("per_page")
//var perPage: Long = 0
//@field:SerializedName("total")
//var total: Long = 0
//@field:SerializedName("total_pages")
//var totalPages: Int = 0

data class UserListBean(
    var avatar: String,
    var email: String,
    var first_name: String,
    var last_name: String,
    var id: Int
)
