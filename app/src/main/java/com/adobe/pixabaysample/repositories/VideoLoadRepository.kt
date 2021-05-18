package com.adobe.pixabaysample.repositories

import com.adobe.pixabaysample.BuildConfig
import com.adobe.pixabaysample.datamodels.Hits
import com.adobe.pixabaysample.endpoints.PixabayEndpoints
import javax.inject.Inject

class VideoLoadRepository @Inject constructor(
    private val endpoint: PixabayEndpoints
) {

    suspend fun loadVideos(term: String): Hits {
        return endpoint.loadVideos(BuildConfig.PIXABAY_API_KEY, term)
    }
}