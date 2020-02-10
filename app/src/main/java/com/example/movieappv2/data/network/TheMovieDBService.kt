package com.example.movieappv2.data.network

import com.example.movieappv2.data.network.response.DataResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Provides
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface TheMovieDBService {

    @GET("popular?")
    fun getPopular(@Query("language") language : String = "en-US",
                   @Query("page") page : Int) : Deferred<DataResponse>

    @GET("top_rated?")
    fun getTopRated(@Query("language") language : String = "en-US",
                    @Query("page") page : Int) : Deferred<DataResponse>

//    companion object {
//        operator fun invoke ( connectivityInterceptorImpl: ConnectivityInterceptorImpl): TheMovieDBService {
//            val requestInterceptor = Interceptor {chain ->
//
//                val url = chain.request()
//                    .url()
//                    .newBuilder()
//                    .addQueryParameter("api_key", API_KEY)
//                    .build()
//
//                val request = chain.request()
//                    .newBuilder()
//                    .url(url)
//                    .build()
//
//                return@Interceptor chain.proceed(request)
//
//            }
//
//            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(requestInterceptor)
//                .addInterceptor(connectivityInterceptorImpl)
//                .build()
//
//            return Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl("https://api.themoviedb.org/3/movie/")
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(TheMovieDBService::class.java)
//        }
//    }
}
