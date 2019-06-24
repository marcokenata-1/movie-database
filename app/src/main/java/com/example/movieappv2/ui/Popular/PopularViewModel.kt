package com.example.movieappv2.ui.Popular

import android.os.Bundle
import androidx.lifecycle.ViewModel;
import com.example.movieappv2.data.repository.MovieRepository
import com.example.movieappv2.internal.lazyDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

public class PopularViewModel(
private val movieRepository: MovieRepository
) : ViewModel(), CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    val moviePopular by lazyDeferred {
        movieRepository.fetchPopularMoviesRepo(1)
    }


}
