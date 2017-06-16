package com.lp.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val iArray: IntArray = intArrayOf(1, 2, 3)
    val sArray: Array<String> = Array(3, { i -> i.toString() })
    val anyArray: Array<Any> = arrayOf(1, "2", 3.0, 4f)
    val lArray: LongArray = longArrayOf(1L, 2L, 3L)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        println(sum1(iArray[0], iArray[1]))
        println(max2(11, 22))
        var a: Int = 4
        var shl: Int = a shl (1) //左移运算符<<
        var shr: Int = a shr (2) //右移运算符>>
        var ushr: Int = a ushr (3) //无符号右移，高位补0 >>>
        var and: Int = 2 and (4)   //按位与操作 &
        var or: Int = 2 or (4) //按位或操作 |
        var xor: Int = 2 xor (6)  //按位异或操作 ^
        print("\nshl:$shl\nshr:$shr \nushr:$ushr")
        print("\nand：$and\nor:$or\nxor:$xor")
    }

    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b

    fun max1(a: Int, b: Int): Unit {
        if (a > b) {
            println(a)
        } else {
            println(b)
        }
    }

    fun max2(a: Int, b: Int) = if (a > b) a else b

    fun loop(array: Array<String>) {
        //1.
        for (str in array) {
            println(str)
        }
        //2.
        array.forEach {
            println(it)
        }
        //3.
        for (i in array.indices) {
            println(array[i])
        }
        //4.
        val i = 0
        when (i < array.size) {
            println(array[i])
        }
    }

    fun whenFun(obj: Any) {
        when (obj) {

        }
    }
}
