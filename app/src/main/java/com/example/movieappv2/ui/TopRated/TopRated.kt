package com.example.movieappv2.ui.TopRated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieappv2.R
import com.example.movieappv2.ui.adapter.FragmentAdapter
import com.example.movieappv2.ui.base.ScopeFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.top_rated_fragment.*
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
        AndroidSupportInjection.inject(this)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TopRatedViewModel::class.java)
        viewModel.bindUI()

        viewModel.titleMovieTopRated.observe(this, Observer { value ->
            adapter = FragmentAdapter(this@TopRated.context, value.results)
            gvTopRatedFragment.adapter = adapter
        })

    }

}
