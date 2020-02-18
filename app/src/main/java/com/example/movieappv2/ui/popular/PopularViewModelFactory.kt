package com.example.movieappv2.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappv2.data.repository.MovieRepositoryImpl
import dagger.Module
import javax.inject.Inject

@Module
class PopularViewModelFactory @Inject constructor(
    private val movieRepositoryImpl: MovieRepositoryImpl
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PopularViewModel(movieRepositoryImpl) as T
    }
}
