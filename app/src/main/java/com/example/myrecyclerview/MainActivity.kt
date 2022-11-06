package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
//    val binding by lazy{
//        ActivityMainBinding.inflate(layoutInflater)
//    }

    private val todos = listOf(
        Todo("pureum 1", false),
        Todo("pureum 2", false),
        Todo("pureum 3", false),
        Todo("pureum 4", false),
        Todo("pureum 5", false),
        Todo("pureum 6", false),
        Todo("pureum 7", false),
        Todo("pureum 8", false),
        Todo("pureum 9", false),
        Todo("pureum 10", false),
        Todo("pureum 11", false),
        Todo("pureum 12", false),
        Todo("pureum 13", false),
        Todo("pureum 14", false),
        Todo("pureum 15", false),
        Todo("pureum 16", false),
        Todo("pureum 17", false),
        Todo("pureum 18", false),
        Todo("pureum 19", false),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init(){
        binding.todoList.layoutManager = LinearLayoutManager(this)
        binding.todoList.adapter = TodoAdapter(todos)
        binding.clearButton.setOnClickListener{
            (binding.todoList.adapter as? TodoAdapter)?.clearAll()
        }
    }
}