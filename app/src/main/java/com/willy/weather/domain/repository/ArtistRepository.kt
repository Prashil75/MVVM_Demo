package com.willy.weather.domain.repository

import com.willy.weather.data.model.artist.Artist

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

interface ArtistRepository {

    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}