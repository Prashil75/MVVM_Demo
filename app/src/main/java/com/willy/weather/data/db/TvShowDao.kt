package com.willy.weather.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.willy.weather.data.model.tvshow.TvShow

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies : List<TvShow>)

    @Query("Delete from popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("Select * from popular_tvShows")
    suspend fun getTvShows() : List<TvShow>
}