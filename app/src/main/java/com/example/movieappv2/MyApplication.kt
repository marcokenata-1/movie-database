package com.example.movieappv2

import android.app.Activity
import android.app.Application
import com.example.movieappv2.data.network.*
import com.example.movieappv2.data.repository.MovieRepository
import com.example.movieappv2.data.repository.MovieRepositoryImpl
import com.example.movieappv2.di.AppComponent
import com.example.movieappv2.di.DaggerAppComponent
import com.example.movieappv2.ui.Popular.PopularViewModelFactory
import com.example.movieappv2.ui.TopRated.TopRatedViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import javax.inject.Inject

class MyApplication: Application(), HasActivityInjector  {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>



    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
}