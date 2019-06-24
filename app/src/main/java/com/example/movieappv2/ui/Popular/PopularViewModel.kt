package com.example.movieappv2.ui.Popular

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappv2.data.network.response.DataResponse
import com.example.movieappv2.data.repository.MovieRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class PopularViewModel(
    private val movieRepository: MovieRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val titleMovie = MutableLiveData<DataResponse>()


    fun bindUI() = launch {
        titleMovie.postValue(movieRepository.fetchPopularMoviesRepo(1).value)
    }

}
