package com.example.gallerymuslim.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gallerymuslim.databinding.ItemProductBinding
import com.example.gallerymuslim.entities.GalleryEntities

class HomeAdapter(val onSelected: (GalleryEntities) -> Unit) :
    ListAdapter<GalleryEntities, HomeAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<GalleryEntities>() {
            override fun areItemsTheSame(
                oldItem: GalleryEntities,
                newItem: GalleryEntities
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GalleryEntities,
                newItem: GalleryEntities
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(data: GalleryEntities) {
            binding.apply {
                tvProductName.text = data.productName
                tvProductSize.text = "Size: ${data.productSize}"
                itemView.setOnClickListener {
                    onSelected.invoke(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    override fun submitList(list: MutableList<GalleryEntities>?) {
        super.submitList(list?.map { it.copy() })
    }
}