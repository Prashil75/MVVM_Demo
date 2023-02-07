package com.willy.weather.presentation.di.core

import com.willy.weather.presentation.di.artist.ArtistSubComponent
import com.willy.weather.presentation.di.movie.MovieSubComponent
import com.willy.weather.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Singleton
@Component(modules = [AppModule::class, CacheDataModel::class, DatabaseModule::class, LocalDataModule::class, NetModule::class,
                        RemoteDataModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
}