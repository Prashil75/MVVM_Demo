package com.willy.weather.data.repository.movie.datasource

import com.willy.weather.data.model.movie.Movie

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movie: List<Movie>)
    suspend fun clearAll()
}