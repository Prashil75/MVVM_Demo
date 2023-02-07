package com.willy.weather.presentation.di

import com.willy.weather.presentation.di.movie.MovieSubComponent
import com.willy.weather.presentation.di.tvshow.TvShowSubComponent
import com.willy.weather.presentation.di.artist.ArtistSubComponent

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}