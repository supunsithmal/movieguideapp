package com.sithmal.tvguideapp.net

import com.sithmal.tvguideapp.net.models.TopRatedResponce
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface TMDBApi {

    //https://api.themoviedb.org/3/movie/top_rated?api_key=f00c7c0a716b7100d0dbae0e18264bb9&language=en-US&page=1

    @GET("3/movie/top_rated")
    fun getTopRated():Call<String>


    @GET("3/movie/top_rated")
    fun getPopularAsync():Deferred<Response<TopRatedResponce>>

}