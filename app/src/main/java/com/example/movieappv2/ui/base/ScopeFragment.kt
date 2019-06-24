package com.example.movieappv2.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class ScopeFragment : Fragment() , CoroutineScope {

    private lateinit var job : Job

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = SupervisorJob()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}