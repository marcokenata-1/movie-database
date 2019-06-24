package com.example.movieappv2

import android.app.Application
import com.example.movieappv2.data.network.*
import com.example.movieappv2.data.repository.MovieRepository
import com.example.movieappv2.data.repository.MovieRepositoryImpl
import com.example.movieappv2.ui.Popular.PopularViewModelFactory
import com.example.movieappv2.ui.TopRated.TopRatedViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidModule(this@MyApplication))

        bind<ConnectivityInterceptor>() with  singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { TheMovieDBService(instance()) }
        bind<MovieDataSource>() with singleton { MovieDataSourceImpl(instance()) }
        bind<MovieRepository>() with singleton { MovieRepositoryImpl(instance()) }
        bind() from provider { PopularViewModelFactory(instance()) }
        bind() from provider { TopRatedViewModelFactory(instance()) }
    }


    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}