package com.example.movieappv2.di

import androidx.lifecycle.ViewModel
import com.example.movieappv2.ui.popular.PopularViewModel
import com.example.movieappv2.ui.testautoresize.TestAutoResizeViewModel
import com.example.movieappv2.ui.toprated.TopRatedViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(TestAutoResizeViewModel::class)
    abstract fun bindTestAutoResizeViewModel(viewModel: TestAutoResizeViewModel) : ViewModel
}
