package com.example.movieappv2.ui.TopRated

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.movieappv2.MyApplication
import com.example.movieappv2.MyApplication_MembersInjector

import com.example.movieappv2.R
import com.example.movieappv2.di.DaggerAppComponent
import com.example.movieappv2.ui.Popular.PopularViewModel
import com.example.movieappv2.ui.Popular.PopularViewModelFactory
import com.example.movieappv2.ui.adapter.FragmentAdapter
import com.example.movieappv2.ui.base.ScopeFragment
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.top_rated_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import javax.inject.Inject

class TopRated : ScopeFragment() {


//    override val kodein by closestKodein()
//
    @Inject lateinit var viewModelFactory : TopRatedViewModelFactory

    private lateinit var viewModel: TopRatedViewModel

    var adapter: FragmentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_rated_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {



        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TopRatedViewModel::class.java)
        viewModel.bindUI()

        viewModel.titleMovieTopRated.observe(this, Observer { value ->
            adapter = FragmentAdapter(this@TopRated.context, value.results)
            gvTopRatedFragment.adapter = adapter
        })

//        bindUI()
    }
//
//    fun bindUI() = launch {
//        val movie = viewModel.movieTopRated.await()
//
//        movie.observe(this@TopRated, Observer {
//            if (it == null) return@Observer
//
//            updateText(it.toString())
//        })
//
//    }
//
//    fun updateText(text : String){
//        tv_topRated.text = text
//    }

}
