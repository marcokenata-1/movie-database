package com.example.movieappv2.di

import com.example.movieappv2.ui.Popular.Popular
import com.example.movieappv2.ui.Popular.PopularViewModelFactory
import com.example.movieappv2.ui.TopRated.TopRated
import com.example.movieappv2.ui.TopRated.TopRatedViewModelFactory
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule() {
    @ContributesAndroidInjector
    internal abstract fun Popular() : Popular

    @ContributesAndroidInjector
    internal abstract fun TopRated() : TopRated
}