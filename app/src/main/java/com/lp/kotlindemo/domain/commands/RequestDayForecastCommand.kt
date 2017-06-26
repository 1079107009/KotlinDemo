package com.lp.kotlindemo.domain.commands

import com.lp.kotlindemo.domain.datasource.ForecastProvider
import com.lp.kotlindemo.domain.model.Forecast


/**
 * Created by LiPin on 2017/6/26 14:14.
 * 描述：
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}