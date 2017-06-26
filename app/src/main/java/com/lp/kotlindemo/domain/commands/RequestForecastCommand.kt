package com.lp.kotlindemo.domain.commands

import com.lp.kotlindemo.domain.datasource.ForecastProvider
import com.lp.kotlindemo.domain.model.ForecastList


/**
 * Created by LiPin on 2017/6/26 14:15.
 * 描述：
 */
class RequestForecastCommand(  val zipCode: Long,
                               val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}