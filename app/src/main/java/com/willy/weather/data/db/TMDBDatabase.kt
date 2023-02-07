package com.willy.weather.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.willy.weather.data.model.artist.Artist
import com.willy.weather.data.model.movie.Movie
import com.willy.weather.data.model.tvshow.TvShow

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Database(entities = [Movie::class, Artist::class, TvShow::class], version = 1,exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){

    abstract fun movieDao() : MovieDao
    abstract fun artistDao() : ArtistDao
    abstract fun tvSowDao() : TvShowDao

    companion object{


    }
}