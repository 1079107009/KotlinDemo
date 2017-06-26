package com.lp.kotlindemo.data.server

import com.lp.kotlindemo.data.db.ForecastDb
import com.lp.kotlindemo.domain.datasource.ForecastDataSource
import com.lp.kotlindemo.domain.model.ForecastList

/**
 * Created by LiPin on 2017/6/26 15:11.
 * 描述：
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()
}