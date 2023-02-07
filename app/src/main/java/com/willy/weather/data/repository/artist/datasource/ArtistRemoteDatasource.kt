package com.willy.weather.data.repository.artist.datasource

import com.willy.weather.data.model.artist.ArtistList
import retrofit2.Response

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

interface ArtistRemoteDatasource {
   suspend fun getArtists(): Response<ArtistList>
}