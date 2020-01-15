package com.example.pagingpractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingpractice.page.PagedAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var activityViewModel: ActivityViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = PagedAdapter()

        recyclerView.apply {
            layoutManager = GridLayoutManager(MainActivity(),2)
            hasFixedSize()
        }
        activityViewModel.userPagedList.observe(this, Observer {
            adapter.submitList(it)


            Log.d("userPagedListAct","$it")

        })
        recyclerView.adapter = adapter


    }
}
