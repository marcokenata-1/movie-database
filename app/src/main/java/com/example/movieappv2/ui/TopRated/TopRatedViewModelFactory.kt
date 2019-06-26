package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappv2.data.repository.MovieRepositoryImpl
import dagger.Module
import javax.inject.Inject

@Module
class TopRatedViewModelFactory @Inject constructor(
    private val movieRepositoryImpl: MovieRepositoryImpl
) : ViewModelProvider.Factory {

//    @Provides
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopRatedViewModel(movieRepositoryImpl) as T
    }
}