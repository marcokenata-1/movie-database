package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappv2.data.repository.MovieRepository
import com.example.movieappv2.ui.Popular.PopularViewModel

class TopRatedViewModelFactory(
    private val movieRepository: MovieRepository
) : ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopRatedViewModel(movieRepository) as T
    }
}