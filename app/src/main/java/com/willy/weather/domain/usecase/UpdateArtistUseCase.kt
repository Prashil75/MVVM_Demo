package com.willy.weather.domain.usecase

import com.willy.weather.data.model.artist.Artist
import com.willy.weather.domain.repository.ArtistRepository

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}