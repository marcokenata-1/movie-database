package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappv2.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class TopRatedViewModelFactory @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModelProvider.Factory {

    @Provides
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopRatedViewModel(movieRepository) as T
    }
}