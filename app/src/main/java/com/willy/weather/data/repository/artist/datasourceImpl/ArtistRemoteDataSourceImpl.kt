package com.willy.weather.data.repository.artist.datasourceImpl

import com.willy.weather.data.api.TMDBService
import com.willy.weather.data.model.artist.ArtistList
import com.willy.weather.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}

