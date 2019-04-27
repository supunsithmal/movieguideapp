package com.sithmal.tvguideapp

import android.app.Application
import com.sithmal.tvguideapp.dagger.DataModule
import com.sithmal.tvguideapp.dagger.TVGuideAppComponent
import com.sithmal.tvguideapp.dagger.TVGuideAppModule

class TVGuideApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerTVGuideAppComponent.builder()
            .tVGuideAppModule(TVGuideAppModule(this))
            .dataModule(DataModule())
            .build()
    }

    companion object {
        var component: TVGuideAppComponent? = null
    }



}