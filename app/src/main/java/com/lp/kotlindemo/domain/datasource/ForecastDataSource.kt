package com.lp.kotlindemo.domain.datasource

import com.lp.kotlindemo.domain.model.Forecast
import com.lp.kotlindemo.domain.model.ForecastList


/**
 * Created by LiPin on 2017/6/26 14:17.
 * 描述：
 */

interface ForecastDataSource {
    /**
     *
     */
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    /**
     *
     */
    fun requestDayForecast(id: Long): Forecast?
}
