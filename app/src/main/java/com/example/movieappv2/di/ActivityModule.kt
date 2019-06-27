package com.example.movieappv2.di

import com.example.movieappv2.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivityInjector() : MainActivity
}