package com.adobe.pixabaysample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adobe.pixabaysample.databinding.ItemVideoPreviewBinding
import com.adobe.pixabaysample.datamodels.VideoPreview
import com.bumptech.glide.Glide

class ListVideosAdapter: ListAdapter<VideoPreview, ListVideosAdapter.ViewHolder>(VideosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemVideoPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    class ViewHolder(private val binding: ItemVideoPreviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(video: VideoPreview, position: Int) {

            //We want to simulate "starring" functionality by
            if (position % 5 == 0) {
                binding.starredImageview.visibility = View.VISIBLE
            } else {
                binding.starredImageview.visibility = View.INVISIBLE

                Glide.with(binding.root)
                    .load("https://i.vimeocdn.com/video/${ video.thumbnailUrl }_960x540.jpg")
                    .into(binding.videoPreviewImageview)
            }
        }
    }
}