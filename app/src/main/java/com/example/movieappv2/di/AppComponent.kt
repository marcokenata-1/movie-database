package com.example.movieappv2.di

import android.app.Application
import com.example.movieappv2.MyApplication
import com.example.movieappv2.data.repository.MovieRepositoryImpl
import com.example.movieappv2.ui.Popular.Popular
import com.example.movieappv2.ui.TopRated.TopRated
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,ActivityBuilder::class,MovieRepositoryImpl::class,NetModule::class))
interface AppComponent : AndroidInjector<MyApplication>{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun movieImplementation(movieRepositoryImpl: MovieRepositoryImpl)
        fun build(): AppComponent
    }

    fun inject(popular: Popular)

    fun inject(topRated: TopRated)
}