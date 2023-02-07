package com.willy.weather.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.willy.weather.domain.usecase.GetArtistUseCase
import com.willy.weather.domain.usecase.UpdateArtistUseCase

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(
            getArtistsUseCase,
            updateArtistsUseCase
        ) as T
    }
}