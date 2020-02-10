package com.example.movieappv2.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.movieappv2.data.network.MovieDataSourceImpl
import com.example.movieappv2.data.network.response.DataResponse
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
class MovieRepositoryImpl @Inject constructor(
    private val movieDataSourceImpl: MovieDataSourceImpl
) {

    @Provides
    suspend fun fetchPopularMoviesRepo(page: Int): LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            movieDataSourceImpl.fetchPopularMovies(page)
            return@withContext movieDataSourceImpl.popularMovies
        }
    }

    @Provides
    suspend fun fetchTopRatedMoviesRepo(page: Int): LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            movieDataSourceImpl.fetchTopRatedMovies(page)
            return@withContext movieDataSourceImpl.topRatedMovies
        }
    }
}
