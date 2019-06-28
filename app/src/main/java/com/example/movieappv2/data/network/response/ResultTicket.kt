package com.example.movieappv2.data.network.response

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieappv2.data.network.imgUrl

data class ResultTicket (
    val posterPath : String,
    val title : String,
    val genre : String
)

class Binder1 {
    companion object {
        @BindingAdapter("posterImageTicket")
        @JvmStatic
        fun loadPoster(imageView: ImageView, posterPath: String) {
            Glide.with(imageView.context)
                .load(imgUrl + posterPath)
                .into(imageView)
        }
    }
}