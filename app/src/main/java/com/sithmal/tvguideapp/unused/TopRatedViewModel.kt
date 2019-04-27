package com.sithmal.tvguideapp.unused

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.sithmal.tvguideapp.TVGuideApplication
import com.sithmal.tvguideapp.net.TMDBClient
import com.sithmal.tvguideapp.repo.MovieRepository
import javax.inject.Inject

class TopRatedViewModel :ViewModel(){

    @Inject
    lateinit var movieRepository: MovieRepository

    var results = MutableLiveData<String>()


    init {
        TVGuideApplication.component?.inject(this)
        val result = movieRepository.getTopRatedMovies()
        Log.d("TMDBApp",result.toString() )
    }

}