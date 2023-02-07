package com.willy.weather.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.willy.weather.domain.usecase.GetArtistUseCase
import com.willy.weather.domain.usecase.UpdateArtistUseCase

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }

}