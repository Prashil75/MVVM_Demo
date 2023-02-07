package com.willy.weather.presentation.di.movie

import com.willy.weather.domain.usecase.GetMoviesUseCase
import com.willy.weather.domain.usecase.UpdateMovieUseCase
import com.willy.weather.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Module
class MovieModule {

//    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {

        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}