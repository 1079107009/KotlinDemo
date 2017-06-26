package com.lp.kotlindemo.ui

import android.app.Application
import com.lp.kotlindemo.extensions.DelegatesExt

/**
 * Created by LiPin on 2017/6/26 14:55.
 * Android有一个问题，就是我们不能去控制很多类的构造函数。
 * 比如，我们不能初始化一个非null属性，因为它的值需要在构造函数中去定义。
 * 所以我们需要一个可null的变量，和一个返回非null值的函数。
 * 我们知道我们一直都有一个App实例，但是在它调用onCreate之前我们不能去操作任何事情，所以我们为了安全性，
 * 我们假设instance()函数将会总是返回一个非null的app实例。但是这个方案看起来有点不自然。
 * 我们需要定义个一个属性（已经有了getter和setter），然后通过一个函数来返回那个属性。
 * 我们有其他方法去达到相似的效果么？是的，我们可以通过委托这个属性的值给另外一个类。这个就是我们知道的委托属性。
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}