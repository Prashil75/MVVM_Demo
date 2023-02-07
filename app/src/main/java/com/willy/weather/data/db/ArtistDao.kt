package com.willy.weather.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.willy.weather.data.model.artist.Artist

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(movies : List<Artist>)

    @Query("Delete from popular_artists")
    suspend fun deleteAllArtist()

    @Query("Select * from popular_artists")
    suspend fun getArtist() : List<Artist>

}