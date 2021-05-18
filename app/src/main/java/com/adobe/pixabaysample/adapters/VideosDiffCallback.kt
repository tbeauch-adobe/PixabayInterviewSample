package com.adobe.pixabaysample.adapters

import androidx.recyclerview.widget.DiffUtil
import com.adobe.pixabaysample.datamodels.VideoPreview

class VideosDiffCallback: DiffUtil.ItemCallback<VideoPreview>() {

    override fun areItemsTheSame(oldItem: VideoPreview, newItem: VideoPreview): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: VideoPreview, newItem: VideoPreview): Boolean {
        return oldItem.videoUrl == newItem.videoUrl &&
                oldItem.thumbnailUrl == newItem.thumbnailUrl
    }

}