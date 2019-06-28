package com.example.movieappv2.data.network.response

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieappv2.data.network.imgUrl
import com.example.movieappv2.data.network.urlBackdrop
import com.google.gson.annotations.SerializedName

data class ResultDetails(
//    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
//    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
//    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
//    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)

class Binder {
    companion object {
        @BindingAdapter("backdropImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, backdropPath: String) {
            Glide.with(imageView.context)
                .load(urlBackdrop + backdropPath)
                .into(imageView)
        }

        @BindingAdapter("posterImage")
        @JvmStatic
        fun loadPoster(imageView: ImageView, posterPath: String) {
            Glide.with(imageView.context)
                .load(imgUrl + posterPath)
                .into(imageView)
        }
    }
}