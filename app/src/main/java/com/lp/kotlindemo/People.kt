package com.lp.kotlindemo

/**
 * Created by LiPin on 2017/6/22 18:59.
 * constructor:构造函数
 * constructor无修饰符(如：private)时，constructor可以省略：
 * 当是无参构造函数时，整个构造函数部分也可以省略，省略的构造函数默认是public的
 * 由于primary constructor不能包含任何代码，因此使用 init 代码块对其初始化,
 * 同时可以在初始化代码块中使用构造函数的参数
 */
open class People private constructor(name: String, sex: String) {
    //可以类中初始化属性：
    public val name1 = name.toUpperCase()

    //次构造函数，使用constructor前缀声明，且必须调用primary constructor，使用this关键字
    constructor(name: String, sex: String, age: Int) : this(name, sex) {
        println(name)
    }

    init {
        println("初始化操作，可使用constructor参数")
    }

    //需要open修饰，子类才可以
    open fun say(name: String) {
        println("my name is $name")
    }

    class Student(name: String, age: Int) : People(name, sex = "男", age = 18) {
        var test: Number = 3
        private var name2: String?
            get() = name2
            set(value) {
                name2 = value
            }

        override fun say(name: String) {
            super.say(name)
        }
    }

    data class Staff<T>(var name: String, val position: String, var age: T)
}

