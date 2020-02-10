package com.example.movieappv2.di

import com.example.movieappv2.data.network.API_KEY
import com.example.movieappv2.data.network.TheMovieDBService
import com.example.movieappv2.data.network.baseUrl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetModule {

    val requestInterceptor = Interceptor {chain ->

        val url = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)

    }

    @Provides
    @Singleton
    fun providesHttpClient() : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()


    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : TheMovieDBService {
        return Builder().client(okHttpClient).baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(TheMovieDBService::class.java)
    }
}
