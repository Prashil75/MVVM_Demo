package com.willy.weather.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.willy.weather.data.db.ArtistDao
import com.willy.weather.data.db.MovieDao
import com.willy.weather.data.db.TMDBDatabase
import com.willy.weather.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvSowDao()
    }


    @Singleton
    @Provides
    fun provideArtist(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

}