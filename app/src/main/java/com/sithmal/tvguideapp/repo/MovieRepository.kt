package com.sithmal.tvguideapp.repo

import android.arch.lifecycle.MutableLiveData
import com.sithmal.tvguideapp.TVGuideApplication
import com.sithmal.tvguideapp.net.Result
import com.sithmal.tvguideapp.net.TMDBApi
import com.sithmal.tvguideapp.net.models.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(private val api:TMDBApi):BaseRepository(){

    fun getTopRatedMovies(): MutableLiveData<Result<String>> {
        val data = MutableLiveData<Result<String>>()
        val call = api.getTopRated()

        call.enqueue(object :Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                data.value = Result.Error(IOException("Network Error"))
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    data.value = Result.Success(response.body()!!)
                }else{
                    data.value = Result.Error(IOException("Server Error"))
                }
            }
        })
        return data
    }

}