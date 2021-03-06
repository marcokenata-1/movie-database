package com.example.movieappv2.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.example.movieappv2.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ConnectivityInterceptorImpl @Inject constructor(context: Context) : Interceptor {
    private val appContext = context.applicationContext

    @Inject
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()){
            throw NoConnectivityException()
        }
        return chain.proceed(chain.request())
    }

    private fun isOnline() : Boolean {
        val ConnectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = ConnectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }


}