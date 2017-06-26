package com.lp.kotlindemo.domain.commands

/**
 * Created by LiPin on 2017/6/26 13:36.
 * 描述：这个command会执行一个操作并且返回某种类型的对象，这个类型可以通过范型被指定。你需要知道一个有趣的概念，
 * 一切kotlin函数都会返回一个值。如果没有指定，它就默认返回一个Unit类。所以如果我们想让Command不返回数据，
 * 我们可以指定它的类型为Unit。
 */
public interface Command<T> {
    fun execute(): T
}