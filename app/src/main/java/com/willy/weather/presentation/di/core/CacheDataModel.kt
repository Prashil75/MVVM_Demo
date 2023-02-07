package com.willy.weather.presentation.di.core

import com.willy.weather.data.repository.artist.datasource.ArtistCacheDataSource
import com.willy.weather.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.willy.weather.data.repository.movie.datasource.MovieCacheDataSource
import com.willy.weather.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.willy.weather.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.willy.weather.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
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
class CacheDataModel {

    @Singleton
    @Provides
    fun provideMovieDataCacheSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowDataCacheSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistDataCacheSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}