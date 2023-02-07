package com.willy.weather.presentation.di.core

import com.willy.weather.data.api.TMDBService
import com.willy.weather.data.repository.artist.datasource.ArtistRemoteDatasource
import com.willy.weather.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.willy.weather.data.repository.movie.datasource.MovieRemoteDataSource
import com.willy.weather.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.willy.weather.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.willy.weather.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
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
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService = tmdbService, apiKey = apiKey)
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(tmdbService = tmdbService, apiKey = apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(tmdbService = tmdbService, apiKey = apiKey)
    }


}