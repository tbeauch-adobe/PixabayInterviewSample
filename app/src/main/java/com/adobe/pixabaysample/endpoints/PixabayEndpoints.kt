package com.adobe.pixabaysample.endpoints

import com.adobe.pixabaysample.datamodels.Hits
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayEndpoints {

    @GET("videos/")
    suspend fun loadVideos(@Query("key") key: String, @Query("q") term: String): Hits
}