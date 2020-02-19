package com.example.movieappv2.cucumber.steps

import android.content.Context
import android.util.Log
import androidx.test.InstrumentationRegistry
import com.example.movieappv2.data.network.baseUrl
import com.example.movieappv2.utils.RestServiceTestHelper
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import java.io.IOException

abstract class BaseSteps {

    private var mockWebServer : MockWebServer? = null

    protected fun initMockWebServer(){
        mockWebServer = MockWebServer()
        initializeWebServer(mockWebServer)

    }

    private fun initializeWebServer(mockWebServer: MockWebServer?){
        try {
            mockWebServer?.start()
        }catch (e:IOException){
            e.printStackTrace()
        }

        baseUrl = mockWebServer?.url("/").toString()
    }


    private fun initializeDispatcher(): Dispatcher {
        return object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(request: RecordedRequest): MockResponse {
                return checkEndpoint(request.path)
            }
        }
    }

    protected fun initializeMockWithDispatcher() {
        mockWebServer!!.setDispatcher(initializeDispatcher())
    }



    private fun checkEndpoint(requestPath: String): MockResponse {
        try {
            when (requestPath) {
                "/popular?&language=en-US&page=1&api_key=ddeb2407d89eb56ea96d59636397646a" -> return MockResponse().setResponseCode(200)
                    .setBody(setMockResponseBodyInPackage("popular.json"))
                "/top_rated?&language=en-US&page=1&api_key=ddeb2407d89eb56ea96d59636397646a" -> return MockResponse().setResponseCode(200)
                    .setBody(setMockResponseBodyInPackage("top_rated.json"))
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return MockResponse().setResponseCode(404)
    }

    private val instrumentation: Context
        get() = InstrumentationRegistry.getContext()

    @Throws(Exception::class)
    private fun setMockResponseBody(fileJson: String): String {
        return RestServiceTestHelper.getStringFromFile(instrumentation, fileJson)
    }

    @Throws(Exception::class)
    private fun setMockResponseBodyInPackage(fileJson: String): String {
        return RestServiceTestHelper.getStringFromFile(instrumentation, "responses/" + fileJson)
    }

}
