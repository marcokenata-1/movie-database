package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappv2.data.network.response.DataResponse
import com.example.movieappv2.data.repository.MovieRepository
import com.example.movieappv2.internal.lazyDeferred
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

public class TopRatedViewModel(
    private val movieRepository: MovieRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val titleMovieTopRated = MutableLiveData<DataResponse>()


    fun bindUI() = launch {
        titleMovieTopRated.postValue(movieRepository.fetchTopRatedMoviesRepo(1).value)
    }
}
