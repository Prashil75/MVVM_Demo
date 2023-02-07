package com.willy.weather.data.repository.movie.datasource

import com.willy.weather.data.model.movie.MovieList
import retrofit2.Response

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>
}