package com.sithmal.tvguideapp.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.sithmal.tvguideapp.net.TMDBApi
import com.sithmal.tvguideapp.net.TMDBClient
import dagger.Module
import dagger.Provides

@Module
public class DataModule{

    @Provides
    internal fun provideSharedPreferences(app:Application):SharedPreferences{
        return app.getSharedPreferences("tvguideapp", Context.MODE_PRIVATE)
    }

    @Provides
    internal fun providesTMDBApi(client:TMDBClient):TMDBApi{
        return client.getApi()
    }




}
