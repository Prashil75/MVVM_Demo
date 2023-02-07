package com.willy.weather.domain.usecase

import com.willy.weather.data.model.tvshow.TvShow
import com.willy.weather.domain.repository.TvShowsRepository

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute(): List<TvShow>? = tvShowsRepository.updateTvShows()
}