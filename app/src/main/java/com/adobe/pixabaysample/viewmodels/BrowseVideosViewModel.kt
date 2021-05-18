package com.adobe.pixabaysample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adobe.pixabaysample.datamodels.VideoPreview
import com.adobe.pixabaysample.repositories.VideoLoadRepository
import com.adobe.pixabaysample.usecase.LoadedVideoMapUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BrowseViewState(
    val searchTerm: String = "dogs",
    val videoPreviews: List<VideoPreview> = listOf()
)

@HiltViewModel
class BrowseVideosViewModel @Inject constructor(
    private val repository: VideoLoadRepository,
    private val loadedVideoMapUseCase: LoadedVideoMapUseCase
): ViewModel() {

    val viewState: MutableLiveData<BrowseViewState> = MutableLiveData(BrowseViewState())

    fun loadVideoPreviews(searchTerm: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val loadedVideos = repository.loadVideos(searchTerm)

            val result = loadedVideoMapUseCase.filterAndMapLoadedVideos(loadedVideos.hits, 50)
            viewState.postValue(viewState.value?.copy(videoPreviews = result))
        }
    }

}