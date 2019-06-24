package com.example.movieappv2.ui.Popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieappv2.R
import com.example.movieappv2.ui.adapter.FragmentAdapter
import com.example.movieappv2.ui.base.ScopeFragment
import kotlinx.android.synthetic.main.popular_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class Popular : ScopeFragment(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory: PopularViewModelFactory by instance()

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
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PopularViewModel::class.java)

        viewModel.bindUI()

        viewModel.titleMovie.observe(this, Observer { value ->
//            Log.d("VALUE",value.totalPages.toString())
            adapter = FragmentAdapter(this@Popular.context,value.results)
            gvTopRatedFragment.adapter = adapter
        })


    }

}
