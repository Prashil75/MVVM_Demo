package com.willy.weather.presentation.app

import android.app.Application
import com.willy.weather.BuildConfig
import com.willy.weather.presentation.di.movie.MovieSubComponent
import com.willy.weather.presentation.di.tvshow.TvShowSubComponent
import com.willy.weather.presentation.di.Injector
import com.willy.weather.presentation.di.artist.ArtistSubComponent
import com.willy.weather.presentation.di.core.*

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class App : Application(), Injector {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

//        appComponent = Dagg
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}