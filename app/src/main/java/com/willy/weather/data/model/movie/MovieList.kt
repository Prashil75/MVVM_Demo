package com.willy.weather.data.model.movie


import com.willy.weather.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>

)