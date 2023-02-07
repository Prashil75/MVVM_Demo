package com.willy.weather.presentation.di.artist

import com.willy.weather.presentation.artist.ArtistFragment
import dagger.Subcomponent

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistFragment: ArtistFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}