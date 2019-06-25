package com.example.movieappv2.data.repository

import androidx.lifecycle.LiveData
import com.example.movieappv2.data.network.response.DataResponse
import dagger.Module
import dagger.Provides

interface MovieRepository {

    suspend fun fetchPopularMoviesRepo(page: Int) : LiveData<DataResponse>

    suspend fun fetchTopRatedMoviesRepo(page: Int) : LiveData<DataResponse>
}