package com.willy.weather.presentation.di.core

import com.willy.weather.data.db.ArtistDao
import com.willy.weather.data.db.MovieDao
import com.willy.weather.data.db.TvShowDao
import com.willy.weather.data.repository.artist.datasource.ArtistLocalDataSource
import com.willy.weather.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.willy.weather.data.repository.movie.datasource.MovieLocalDataSource
import com.willy.weather.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.willy.weather.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.willy.weather.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
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
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao = artistDao)
    }
}