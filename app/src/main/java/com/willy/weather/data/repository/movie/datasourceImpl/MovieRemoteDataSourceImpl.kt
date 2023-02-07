package com.willy.weather.data.repository.movie.datasourceImpl

import com.willy.weather.data.api.TMDBService
import com.willy.weather.data.model.movie.MovieList
import com.willy.weather.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class MovieRemoteDataSourceImpl (private val tmdbService: TMDBService, private val apiKey : String):
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}