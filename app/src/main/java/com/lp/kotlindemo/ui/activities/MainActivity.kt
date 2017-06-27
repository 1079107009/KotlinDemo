package com.lp.kotlindemo.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.lp.kotlindemo.R
import com.lp.kotlindemo.domain.commands.RequestForecastCommand
import com.lp.kotlindemo.domain.model.ForecastList
import com.lp.kotlindemo.extensions.DelegatesExt
import com.lp.kotlindemo.ui.adapters.ForecastListAdapter
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), ToolbarManager {

    val iArray: IntArray = intArrayOf(1, 2, 3)
    val sArray: Array<String> = Array(3, { i -> i.toString() })
    val anyArray: Array<Any> = arrayOf(1, "2", 3.0, 4f)
    val lArray: LongArray = longArrayOf(1L, 2L, 3L)
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )
    val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE,
            SettingsActivity.DEFAULT_ZIP)
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    val forecastList by lazy { find<RecyclerView>(R.id.forecast_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
//        println(sum1(iArray[0], iArray[1]))
//        println(max2(11, 22))
//        var a: Int = 4
//        var shl: Int = a shl (1) //左移运算符<<
//        var shr: Int = a shr (2) //右移运算符>>
//        var ushr: Int = a ushr (3) //无符号右移，高位补0 >>>
//        var and: Int = 2 and (4)   //按位与操作 &
//        var or: Int = 2 or (4) //按位或操作 |
//        var xor: Int = 2 xor (6)  //按位异或操作 ^
//        print("\nshl:$shl\nshr:$shr \nushr:$ushr")
//        print("\nand：$and\nor:$or\nxor:$xor")
        loadForecast()
    }

    private fun loadForecast() = async(UI) {
        val result = bg { RequestForecastCommand(zipCode).execute() }
        updateUI(result.await())
    }

    private fun updateUI(weekForecast: ForecastList) {
        val adapter = ForecastListAdapter(weekForecast) {
            startActivity<DetailActivity>(DetailActivity.ID to it.id,
                    DetailActivity.CITY_NAME to weekForecast.city)
        }
        forecastList.adapter = adapter
        toolbarTitle = "${weekForecast.city} (${weekForecast.country})"
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
//        val i = 0
//        when (i < array.size) {
//            println(i)
//        }

        //@定义label，一般用在内层循环中跳到外层循环:i in 0..2等价于java中 for（int i=0;i<=2;i++）效果
        loop@ for (i in 0..2) {
            for (i in 0..3) {
                println(i)
                if (i == 2) {
                }
//                    break@loop //跳到外层循环label处，跳出改层循环
//                    continue@loop  //跳到外层循环，继续往下执行
            }
        }

        //倒序输出5 4 3 2 1 0
        for (i in 5 downTo 0) {
            println(i)
        }

        //设置输出数据步长
        for (i in 0..5 step 3) {
            println(i)  // 输出 14
        }

        //step和downTo混合使用
        for (i in 5 downTo 0 step 3) println(i) //输出52
    }

    fun whenFun(obj: Any) {
        when (obj) {
            25 -> println("25")
            "kotlin" -> println("kotlin")
            is String -> print("is String")
            !is String -> println("not String")
            else -> println("nothing")
        }
    }


}
