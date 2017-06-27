package com.lp.kotlindemo.extensions

import java.text.DateFormat
import java.util.*

/**
 * 扩展函数是指在一个类上增加一种新的行为，甚至我们没有这个类代码的访问权限。
 * 这是一个在缺少有用函数的类上扩展的方法。在Java中，通常会实现很多带有static方法的工具类。
 * Kotlin中扩展函数的一个优势是我们不需要在调用方法的时候把整个对象当作参数传入。
 * 扩展函数表现得就像是属于这个类的一样，而且我们可以使用this关键字和调用所有public方法。
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}
