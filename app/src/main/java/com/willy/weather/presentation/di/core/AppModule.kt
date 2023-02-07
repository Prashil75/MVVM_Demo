package com.willy.weather.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context{
        return context.applicationContext
    }
}