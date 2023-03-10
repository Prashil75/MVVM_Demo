package com.willy.weather.data.model.tvshow


import com.willy.weather.data.model.tvshow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>
)