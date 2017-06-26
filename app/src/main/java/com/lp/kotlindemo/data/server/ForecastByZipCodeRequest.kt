package com.lp.kotlindemo.data.server

import android.util.Log
import com.google.gson.Gson

/**
 * Created by LiPin on 2017/6/26 11:27.
 * 描述：Kotlin允许我们去定义一些行为与静态对象一样的对象。尽管这些对象可以用众所周知的模式来实现，
 * 比如容易实现的单例模式。我们需要一个类里面有一些静态的属性、常量或者函数，我们可以使用companion object。
 * 这个对象被这个类的所有对象所共享，就像Java中的静态属性或者方法。
 */
class ForecastByZipCodeRequest(val zipCode: Long, val gson: Gson = Gson()) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
        return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}