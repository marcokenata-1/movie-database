package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappv2.data.network.response.DataResponse
import com.example.movieappv2.data.repository.MovieRepositoryImpl
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class TopRatedViewModel(
    private val movieRepositoryImpl: MovieRepositoryImpl
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main


    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val titleMovieTopRated = MutableLiveData<DataResponse>()


    fun bindUI() = launch {
        titleMovieTopRated.postValue(movieRepositoryImpl.fetchTopRatedMoviesRepo(1).value)
    }
}
