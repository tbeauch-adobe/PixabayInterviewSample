package com.adobe.pixabaysample.datamodels

data class Hits(val hits: List<VideoDetails>)

data class VideoDetails(
        val picture_id: String,
        val videos: VideoSet,
        val views: Int
)

data class VideoSet(val medium: VideoProps)

data class VideoProps(
        val url: String
)