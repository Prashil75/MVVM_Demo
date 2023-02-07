package com.willy.weather.presentation.di.movie

import com.willy.weather.presentation.movie.MovieFragment
import dagger.Subcomponent

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}