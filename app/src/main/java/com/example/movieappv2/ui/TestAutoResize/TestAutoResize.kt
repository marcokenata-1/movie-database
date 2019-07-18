package com.example.movieappv2.ui.TestAutoResize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieappv2.R
import com.example.movieappv2.ui.adapter.FragmentAdapter
import com.example.movieappv2.ui.adapter.ResizeAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.test_auto_resize_fragment.*
import javax.inject.Inject

class TestAutoResize : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: TestAutoResizeViewModelFactory

    private lateinit var viewModel: TestAutoResizeViewModel

    var adapter: ResizeAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.test_auto_resize_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TestAutoResizeViewModel::class.java)
        viewModel.bindUI()


        viewModel.titleMovie.observe(this, Observer { value ->
                adapter = ResizeAdapter(context,value.results)
                lvAutoResize.adapter = adapter

                resizerButton.setOnClickListener {
                    resizerButton.text = adapter?.textGetter()
                }
            }
        )


    }

}
