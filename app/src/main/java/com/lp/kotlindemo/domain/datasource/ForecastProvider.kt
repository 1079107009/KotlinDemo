package com.lp.kotlindemo.domain.datasource

import com.lp.kotlindemo.data.db.ForecastDb
import com.lp.kotlindemo.data.server.ForecastServer
import com.lp.kotlindemo.domain.model.Forecast
import com.lp.kotlindemo.domain.model.ForecastList
import com.lp.kotlindemo.extensions.firstResult

/**
 * Created by LiPin on 2017/6/26 14:18.
 * 描述：
 */
open class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(
            f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }
}