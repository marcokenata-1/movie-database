package com.example.movieappv2.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.movieappv2.R
import com.example.movieappv2.data.network.response.Result
import com.example.movieappv2.internal.glide.GlideApp
import com.example.movieappv2.ui.MovieDetails
import kotlinx.android.synthetic.main.movie_ticket.view.*

class FragmentAdapter : BaseAdapter {

    var context: Context? = null
    var listOfMovies = ArrayList<Result>()

    constructor(context: Context?, listOfMovies: ArrayList<Result>){
        this.context = context
        this.listOfMovies = listOfMovies
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var movie = listOfMovies[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var movieView = inflator.inflate(R.layout.movie_ticket,null)

        var url = "https://image.tmdb.org/t/p/w500" + movie.posterPath

        movieView.tvMovieName.text = movie.originalTitle

        movieView.tvGenreName.text = genreMatcher(movie.genreIds)

        GlideApp.with(context!!)
            .load(url)
            .into(movieView.ivMovieImage)

        movieView.setOnClickListener {
            val intent = Intent(context, MovieDetails::class.java)
            intent.putExtra("poster_path",movie.posterPath)
            intent.putExtra("backdrop_path",movie.backdropPath)
            intent.putExtra("original_title",movie.originalTitle)
            intent.putExtra("vote_average",movie.voteAverage)
            intent.putExtra("vote_count",movie.voteCount)
            intent.putExtra("release_date",movie.releaseDate)
            intent.putExtra("overview",movie.overview)
            intent.putExtra("original_language",movie.originalLanguage)
            context!!.startActivity(intent)
        }

        return movieView
    }

    override fun getItem(p0: Int): Any {
        return listOfMovies.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listOfMovies.size
    }


    fun genreDatabase() : Map<Int, String> {
        var map = HashMap<Int,String>()
        map.put(28, "Action")
        map.put(12, "Adventure")
        map.put(16, "Animation")
        map.put(35, "Comedy")
        map.put(80, "Crime")
        map.put(99, "Documentary")
        map.put(18, "Drama")
        map.put(10751, "Family")
        map.put(14, "Fantasy")
        map.put(36, "History")
        map.put(27,"Horror")
        map.put(10402, "Music")
        map.put(9648, "Mystery")
        map.put(10749, "Romance")
        map.put(878, "Science Fiction")
        map.put(10770,"TV Movie")
        map.put(53, "Thriller")
        map.put(10752, "War")
        map.put(37, "Western")

        return map
    }

    fun genreMatcher(array : ArrayList<Int>) : String{
        var builder = ""
        for (x in array){
            if (genreDatabase().containsKey(x)){
                builder += genreDatabase().get(x)+", "
            }
        }
        return builder.substring(0,builder.length-2)
    }


}