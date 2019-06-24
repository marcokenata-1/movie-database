package com.example.movieappv2.ui.Popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappv2.data.repository.MovieRepository

class PopularViewModelFactory(
    private val movieRepository: MovieRepository
) : ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PopularViewModel(movieRepository) as T
    }
}