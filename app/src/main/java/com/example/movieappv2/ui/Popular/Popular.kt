package com.example.movieappv2.ui.Popular

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieappv2.R
import com.example.movieappv2.ui.adapter.FragmentAdapter
import com.example.movieappv2.ui.base.ScopeFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.popular_fragment.*
import javax.inject.Inject

class Popular : ScopeFragment() {
//
//    override val kodein by closestKodein()
//
    @Inject
    internal lateinit var viewModelFactory: PopularViewModelFactory

    private lateinit var viewModel: PopularViewModel

    var adapter: FragmentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.popular_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(PopularViewModel::class.java)
        viewModel.bindUI()

        viewModel.titleMovie.observe(this, Observer { value ->
            adapter = FragmentAdapter(context,value.results)
            gvTopRatedFragment.adapter = adapter
        })


    }

}
