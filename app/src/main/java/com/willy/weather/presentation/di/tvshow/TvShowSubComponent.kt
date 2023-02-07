package com.willy.weather.presentation.di.tvshow

import com.willy.weather.presentation.di.movie.MovieModule
import com.willy.weather.presentation.tvshows.TvShowsFragment
import dagger.Subcomponent

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowsFragment: TvShowsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}