package com.sithmal.tvguideapp.net

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject


class TMDBClient @Inject constructor(){

    private val API_KEY = "f00c7c0a716b7100d0dbae0e18264bb9"
    private val BASE_URL = "https://api.themoviedb.org/"
    private lateinit var tmdbApi: TMDBApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(getRequestInterceptor())
            .addInterceptor(getLoggingInterceptor())
            .build()

        tmdbApi = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(TMDBApi::class.java)
    }

    private fun getRequestInterceptor(): Interceptor {
        return Interceptor{ chain ->
            val url = chain
                .request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    fun getApi(): TMDBApi {
        return tmdbApi
    }




}