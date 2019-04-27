package com.sithmal.tvguideapp.dagger

import android.app.Application
import android.content.Context
import com.sithmal.tvguideapp.TVGuideApplication
import dagger.Module
import dagger.Provides

@Module
class TVGuideAppModule (internal val app: TVGuideApplication){

    @Provides
    internal fun provideTVGuideApp(): TVGuideApplication {
        return app
    }

    @Provides
    internal fun provideApplication(app: TVGuideApplication):Application{
        return app
    }

    @Provides
    internal fun providesContext(app: TVGuideApplication):Context{
        return app
    }
}