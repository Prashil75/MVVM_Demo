package com.willy.weather.domain.usecase

import com.willy.weather.data.model.movie.Movie
import com.willy.weather.domain.repository.MovieRepository

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}