package com.example.movieappv2.di

import androidx.lifecycle.ViewModel
import com.example.movieappv2.ui.Popular.PopularViewModel
import com.example.movieappv2.ui.TopRated.TopRatedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PopularViewModel::class)
    abstract fun bindPopularViewModel(viewModel : PopularViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TopRatedViewModel::class)
    abstract fun bindTopRatedViewModel(viewModel: TopRatedViewModel) : ViewModel
}