package com.sithmal.tvguideapp.dagger

import com.sithmal.tvguideapp.net.TMDBClient
import com.sithmal.tvguideapp.views.MainActivity
import com.sithmal.tvguideapp.unused.TopRatedViewModel
import com.sithmal.tvguideapp.repo.MovieRepository
import dagger.Component

@Component(modules = [TVGuideAppModule::class, DataModule::class])
interface TVGuideAppComponent{

    fun inject(mainActivity: MainActivity)
    fun inject(model: TopRatedViewModel)
    fun inject(movieRepository: MovieRepository)

    fun client(): TMDBClient

}