package com.example.movieappv2.data.repository

import androidx.lifecycle.LiveData
import com.example.movieappv2.data.network.MovieDataSource
import com.example.movieappv2.data.network.response.DataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource
) : MovieRepository {
    override suspend fun fetchPopularMoviesRepo(page: Int): LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            movieDataSource.fetchPopularMovies(page)
            return@withContext movieDataSource.popularMovies
        }
    }

    override suspend fun fetchTopRatedMoviesRepo(page: Int): LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            movieDataSource.fetchTopRatedMovies(page)
            return@withContext movieDataSource.popularMovies
        }
    }
}