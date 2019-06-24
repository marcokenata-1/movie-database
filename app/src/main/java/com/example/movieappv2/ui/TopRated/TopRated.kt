package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.movieappv2.R
import com.example.movieappv2.ui.Popular.PopularViewModel
import com.example.movieappv2.ui.Popular.PopularViewModelFactory
import com.example.movieappv2.ui.base.ScopeFragment
import kotlinx.android.synthetic.main.top_rated_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class TopRated : ScopeFragment(), KodeinAware {


    override val kodein by closestKodein()

    private val viewModelFactory : TopRatedViewModelFactory by instance()

    private lateinit var viewModel: TopRatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_rated_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TopRatedViewModel::class.java)
        // TODO: Use the ViewModel

        bindUI()
    }

    fun bindUI() = launch {
        val movie = viewModel.movieTopRated.await()

        movie.observe(this@TopRated, Observer {
            if (it == null) return@Observer

            updateText(it.toString())
        })

    }

    fun updateText(text : String){
        tv_topRated.text = text
    }

}
