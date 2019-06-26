package com.example.movieappv2.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieappv2.data.network.response.DataResponse
import com.example.movieappv2.internal.NoConnectivityException
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class MovieDataSourceImpl @Inject constructor(private val theMovieDBService: TheMovieDBService) {

    private val _popularMovies = MutableLiveData<DataResponse>()

    val popularMovies: LiveData<DataResponse>
        get() = _popularMovies

    private val _topRatedMovies = MutableLiveData<DataResponse>()

    val topRatedMovies: LiveData<DataResponse>
        get() = _topRatedMovies

    @Provides
    suspend fun fetchPopularMovies(page: Int) {
        try {
            val fetchedMovieDBService = theMovieDBService
                .getPopular("en-US",page,"B1")
                .await()

            _popularMovies.postValue(fetchedMovieDBService)

        } catch (e: NoConnectivityException){
            Log.e("Connectivity","No Internet Connection")
        }
    }

    @Provides
    suspend fun fetchTopRatedMovies(page: Int) {
        try {
            val fetchedMovieDBService = theMovieDBService
                .getTopRated("en-US",page,"B1")
                .await()

            _topRatedMovies.postValue(fetchedMovieDBService)

        } catch (e: NoConnectivityException){
            Log.e("Connectivity","No Internet Connection")
        }
    }
}