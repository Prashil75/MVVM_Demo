package com.willy.weather.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.willy.weather.data.model.movie.Movie
import com.willy.weather.domain.usecase.GetMoviesUseCase
import com.willy.weather.domain.usecase.UpdateMovieUseCase

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {

        val moviesList: List<Movie>? = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val movieList: List<Movie>? = updateMovieUseCase.execute()
        emit(movieList)
    }

}