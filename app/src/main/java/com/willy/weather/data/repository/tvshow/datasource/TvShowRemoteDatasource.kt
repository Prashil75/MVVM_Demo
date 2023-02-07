package com.willy.weather.data.repository.tvshow.datasource

import com.willy.weather.data.model.tvshow.TvShowList
import retrofit2.Response

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}