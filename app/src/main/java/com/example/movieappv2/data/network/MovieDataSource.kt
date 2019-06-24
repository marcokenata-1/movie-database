package com.example.movieappv2.data.network

import androidx.lifecycle.LiveData
import com.example.movieappv2.data.network.response.DataResponse

interface MovieDataSource {

    val popularMovies : LiveData<DataResponse>
    val topRatedMovies : LiveData<DataResponse>

    suspend fun fetchPopularMovies (page : Int)

    suspend fun fetchTopRatedMovies (page : Int)

}