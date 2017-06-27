package com.lp.kotlindemo.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.lp.kotlindemo.ui.App
import org.jetbrains.anko.db.*

/**
 * Created by LiPin on 2017/6/26 15:52.
 * 描述：
 */
class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        /**
         * instance这个属性使用了lazy委托，它表示直到它真的被调用才会被创建。
         * 用这种方法，如果数据库从来没有被使用，我们没有必要去创建这个对象。
         * 一般lazy委托的代码块可以阻止在多个不同的线程中创建多个对象。
         * 这个只会发生在两个线程在同事时间访问这个instance对象，它很难发生但是发生具体还有看app的实现。
         * 无论如何，lazy委托是线程安全的
         */
        val instance by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }
}