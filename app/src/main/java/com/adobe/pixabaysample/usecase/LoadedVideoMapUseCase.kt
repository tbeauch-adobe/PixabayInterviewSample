package com.adobe.pixabaysample.usecase

import com.adobe.pixabaysample.datamodels.VideoDetails
import com.adobe.pixabaysample.datamodels.VideoPreview
import javax.inject.Inject

class LoadedVideoMapUseCase @Inject constructor() {

    /**
     * Filter the given list of VideoDetails objects that have a view count greater than the viewCount
     * value passed in to this function. Map the resulting filtered results to the VideoPreview
     * view state object.
     */
    fun filterAndMapLoadedVideos(videoDetails: List<VideoDetails>, viewCount: Int): List<VideoPreview> {
        return videoDetails.filter {
            it.views > viewCount
        }.map {
            VideoPreview(it.picture_id, it.videos.medium.url)
        }
    }
}