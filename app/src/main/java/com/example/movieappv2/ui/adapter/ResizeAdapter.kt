package com.example.movieappv2.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.movieappv2.R
import com.example.movieappv2.data.network.response.Result
import com.example.movieappv2.data.network.response.ResultTicket
import com.example.movieappv2.databinding.MovieTicketRadioBinding

class ResizeAdapter : BaseAdapter {

    var text = ""
    var context: Context? = null
    var listOfMovies = ArrayList<Result>()


    constructor(context: Context?, listOfMovies: ArrayList<Result>){
        this.context = context
        this.listOfMovies = listOfMovies
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var movie = listOfMovies[p0]
        var inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding : MovieTicketRadioBinding = DataBindingUtil.inflate(inflator, R.layout.movie_ticket_radio, null, false)

        binding.result = ResultTicket(movie.posterPath,movie.originalTitle,genreMatcher(movie.genreIds))

        binding.radioButton.setOnClickListener {
            text = "PLIS NONTON DONG "+movie.originalTitle
        }

        return binding.root
    }

    override fun getItem(p0: Int): Any {
        return listOfMovies[p0]
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

    fun textGetter(): String{
        return text
    }
}