package com.lp.kotlindemo.data.server

import com.lp.kotlindemo.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
//当我们使用了两个相同名字的类，我们可以给其中一个指定一个别名
import com.lp.kotlindemo.domain.model.Forecast as ModelForecast

/**
 * Created by LiPin on 2017/6/26 15:13.
 * 描述：根据zipCode和ForecastResult映射为ForecastList
 */
class ServerDataMapper {

    fun convertToDomain(zipCode: Long, forecastResult: ForecastResult) = with(forecastResult) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        //这一条语句，我们就可以循环这个集合并且返回一个转换后的新的List。
        // Kotlin在List中提供了很多不错的函数操作符，它们可以在这个List的每个item中应用这个操作并且任何方式转换它们。
        // 对比Java 7，这是Kotlin其中一个强大的功能。我们很快就会查看所有不同的操作符。知道它们的存在是很重要的，
        // 因为它们要方便得多，并可以节省很多时间和模版。
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
            //如上，我们拷贝了forecast对象然后只修改了dt的属性而没有修改这个对象的其它状态。
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(-1, dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(icon: String) = "http://openweathermap.org/img/w/$icon.png"


}