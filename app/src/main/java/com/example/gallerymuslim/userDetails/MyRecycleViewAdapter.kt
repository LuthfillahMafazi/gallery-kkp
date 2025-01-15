package com.example.gallerymuslim.userDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gallerymuslim.R
import com.example.gallerymuslim.databinding.ListItemBinding
import com.example.gallerymuslim.entities.RegisterEntities

class MyRecycleViewAdapter(private val usersList :List<RegisterEntities>):RecyclerView.Adapter<MyviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.bind(usersList[position])

    }
}

class MyviewHolder(private val binding :ListItemBinding ):RecyclerView.ViewHolder(binding.root){

    fun bind(user : RegisterEntities){
//        binding.FirstNameTextView.text = user.firstName
//        binding.secondNameTextView.text = user.lastName
//        binding.userTextField.text = user.userName
    }

}