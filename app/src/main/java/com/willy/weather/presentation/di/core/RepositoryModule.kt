package com.willy.weather.presentation.di.core

import com.willy.weather.data.repository.artist.ArtistRepositoryImpl
import com.willy.weather.data.repository.artist.datasource.ArtistCacheDataSource
import com.willy.weather.data.repository.artist.datasource.ArtistLocalDataSource
import com.willy.weather.data.repository.artist.datasource.ArtistRemoteDatasource
import com.willy.weather.data.repository.movie.MovieRepositoryImpl
import com.willy.weather.data.repository.movie.datasource.MovieCacheDataSource
import com.willy.weather.data.repository.movie.datasource.MovieLocalDataSource
import com.willy.weather.data.repository.movie.datasource.MovieRemoteDataSource
import com.willy.weather.data.repository.tvshow.TvShowRepositoryImpl
import com.willy.weather.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.willy.weather.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.willy.weather.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.willy.weather.domain.repository.ArtistRepository
import com.willy.weather.domain.repository.MovieRepository
import com.willy.weather.domain.repository.TvShowsRepository
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
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowsRepository: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {

        return TvShowRepositoryImpl(tvShowsRepository, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistsRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}