package com.willy.weather.presentation.di.artist

import com.willy.weather.domain.usecase.GetArtistUseCase
import com.willy.weather.domain.usecase.UpdateArtistUseCase
import com.willy.weather.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Module
class ArtistModule {

//    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {

        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}