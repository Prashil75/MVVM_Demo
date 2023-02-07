package com.willy.weather.presentation.di.core

import com.willy.weather.domain.repository.ArtistRepository
import com.willy.weather.domain.repository.MovieRepository
import com.willy.weather.domain.repository.TvShowsRepository
import com.willy.weather.domain.usecase.*
import dagger.Module
import dagger.Provides

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }
}