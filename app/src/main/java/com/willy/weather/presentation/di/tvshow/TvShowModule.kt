package com.willy.weather.presentation.di.tvshow

import com.willy.weather.domain.usecase.GetTvShowsUseCase
import com.willy.weather.domain.usecase.UpdateTvShowsUseCase
import com.willy.weather.presentation.di.artist.ArtistScope
import com.willy.weather.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Module
class TvShowModule {

//    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {

        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}