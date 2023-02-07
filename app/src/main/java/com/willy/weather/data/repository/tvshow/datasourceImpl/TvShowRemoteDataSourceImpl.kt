package com.willy.weather.data.repository.tvshow.datasourceImpl

import com.willy.weather.data.api.TMDBService
import com.willy.weather.data.model.tvshow.TvShowList
import com.willy.weather.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDatasource {
    override suspend fun getTvShows()
            : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}

