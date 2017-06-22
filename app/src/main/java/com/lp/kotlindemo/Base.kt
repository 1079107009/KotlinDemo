package com.lp.kotlindemo

/**
 * Created by LiPin on 2017/6/22 20:02.
 * 描述：
 */
interface Base {
    fun display()
}
open class BaseImp : Base {
    override fun display() {
        print("just display me.")
    }
}