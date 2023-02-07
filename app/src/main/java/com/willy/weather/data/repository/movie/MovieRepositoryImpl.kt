package com.willy.weather.data.repository.movie

import android.util.Log
import com.willy.weather.domain.repository.MovieRepository
import com.willy.weather.data.model.movie.Movie
import com.willy.weather.data.model.movie.MovieList
import com.willy.weather.data.repository.movie.datasource.MovieCacheDataSource
import com.willy.weather.data.repository.movie.datasource.MovieLocalDataSource
import com.willy.weather.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {

        val newList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newList!!)
        movieCacheDataSource.saveMoviesToCache(newList)

        return newList
    }

    private suspend fun getMoviesFromAPI(): List<Movie>? {

        var movieList = listOf<Movie>()
        try {

            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val responseBody = response.body()

            if (responseBody != null) {
                movieList = responseBody.movies
            } else {
                return emptyList()
            }

        } catch (exception: Exception) {
            Log.i(javaClass.simpleName, exception.message.toString())
            return emptyList()
        }

        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie>? {

        var movieList = listOf<Movie>()
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (exception: Exception) {
            Log.i(javaClass.simpleName, exception.message.toString())
            return emptyList()
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {

            movieList = getMoviesFromAPI()!!
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {

        var movieList = listOf<Movie>()
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (exception: Exception) {
            Log.i(javaClass.simpleName, exception.message.toString())
            return emptyList()
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {

            movieList = getMoviesFromDB()!!
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}