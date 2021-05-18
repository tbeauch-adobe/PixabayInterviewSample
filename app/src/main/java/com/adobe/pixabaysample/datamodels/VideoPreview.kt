package com.adobe.pixabaysample.datamodels

import java.io.Serializable

/**
 * View specific data object to display video previews
 */
data class VideoPreview(
        val thumbnailUrl: String,
        val videoUrl: String
): Serializable