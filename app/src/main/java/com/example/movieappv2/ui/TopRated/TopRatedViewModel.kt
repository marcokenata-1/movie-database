package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.ViewModel
import com.example.movieappv2.data.repository.MovieRepository
import com.example.movieappv2.internal.lazyDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

public class TopRatedViewModel(
    private val movieRepository: MovieRepository
) : ViewModel(), CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    val movieTopRated by lazyDeferred {
        movieRepository.fetchTopRatedMoviesRepo(1)
    }
}
