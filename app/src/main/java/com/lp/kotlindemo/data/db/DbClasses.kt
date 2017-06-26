package com.lp.kotlindemo.data.db

/**
 * Created by LiPin on 2017/6/26 15:23.
 * 属性的值会从一个map中获取value，属性的名字对应这个map中的key。
 * 这个委托可以让我们做一些很强大的事情，因为我们可以很简单地从一个动态地map中创建一个对象实例。
 * 如果我们import kotlin.properties.getValue，我们可以从构造函数映射到val属性来得到一个不可修改的map。
 * 如果我们想去修改map和属性，我们也可以import kotlin.properties.setValue。类需要一个MutableMap作为构造函数的参数。
 */
class CityForecast(val map: MutableMap<String, Any?>, val dailyForecast: List<DayForecast>) {
    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>)
            : this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
    }
}

class DayForecast(var map: MutableMap<String, Any?>) {
    var _id: Long by map
    var date: Long by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: Long, description: String, high: Int, low: Int, iconUrl: String, cityId: Long)
            : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}