package com.example.myrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.databinding.ListItemBinding

/**
 * 2022-11-06
 * pureum
 */
class TodoAdapter(private val dataList : List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoListViewHolder>() {

    fun clearAll(){
        dataList.forEach{
            it.check = true
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        Log.e(javaClass.simpleName, "@@@ onCreateViewHolder: ", )
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return TodoListViewHolder(binding).also{holder->
            binding.todoListBox.setOnCheckedChangeListener { buttonView, isChecked ->
                dataList.getOrNull(holder.adapterPosition)?.check = isChecked
            }

        }
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        Log.e(javaClass.simpleName, "onBindViewHolder: ", )
        holder.bind(dataList[position])
//        holder.binding.todoListBox.setOnCheckedChangeListener { buttonView, isChecked ->
//            Log.e(javaClass.simpleName, "check: ", )
//            dataList[position].check = !isChecked
//
//        }
    }

    override fun getItemCount(): Int = dataList.size

    class TodoListViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(list : Todo){
            binding.todoListText.text = list.myText
            binding.todoListBox.isChecked  = list.check
        }

    }
}