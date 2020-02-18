package com.example.movieappv2.di

import com.example.movieappv2.ui.popular.Popular
import com.example.movieappv2.ui.testautoresize.TestAutoResize
import com.example.movieappv2.ui.toprated.TopRated
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule() {
    @ContributesAndroidInjector
    internal abstract fun Popular() : Popular

    @ContributesAndroidInjector
    internal abstract fun TopRated() : TopRated

    @ContributesAndroidInjector
    internal abstract fun TestAutoResize() : TestAutoResize
}
