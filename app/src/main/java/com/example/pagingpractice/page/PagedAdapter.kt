package com.example.pagingpractice.page

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingpractice.R
import com.example.pagingpractice.User
import com.example.pagingpractice.UserListBean
import com.squareup.picasso.Picasso

class PagedAdapter : PagedListAdapter<UserListBean, PagedAdapter.ViewHolder>(Diff) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.paged_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user = getItem(position)
        user?.let { holder.bindItem(it) }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.image_view)
        private val name_tv: TextView = itemView.findViewById(R.id.name_tv)
        private val id_tv: TextView = itemView.findViewById(R.id.id_tv)

        @SuppressLint("SetTextI18n")
        fun bindItem(userListBean: UserListBean) {

            Picasso.get().load(userListBean.avatar).into(imageView)
            name_tv.text = "Name - ${userListBean.first_name} ${userListBean.last_name}"
            id_tv.text = "Id - ${userListBean.id}"
        }
    }

    companion object {

        private val Diff = object : DiffUtil.ItemCallback<UserListBean>() {
            override fun areContentsTheSame(
                oldItem: UserListBean,
                newItem: UserListBean
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(
                oldItem: UserListBean,
                newItem: UserListBean
            ): Boolean {
                return oldItem.first_name == newItem.first_name
            }
        }
    }

}