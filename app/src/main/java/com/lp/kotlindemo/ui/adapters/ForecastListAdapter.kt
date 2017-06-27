package com.lp.kotlindemo.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lp.kotlindemo.R
import com.lp.kotlindemo.domain.model.Forecast
import com.lp.kotlindemo.domain.model.ForecastList
import com.lp.kotlindemo.extensions.ctx
import com.lp.kotlindemo.extensions.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by LiPin on 2017/6/26 11:16.
 * 内联函数与普通的函数有点不同。一个内联函数会在编译的时候被替换掉，而不是真正的方法调用。
 * 这在一些情况下可以减少内存分配和运行时开销。举个例子，如果我们有一个函数，只接收一个函数作为它的参数。
 * 如果是一个普通的函数，内部会创建一个含有那个函数的对象。另一方面，内联函数会把我们调用这个函数的地方替换掉，
 * 所以它不需要为此生成一个内部的对象。
 */
class ForecastListAdapter :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder> {
    val weekForecast: ForecastList
    val itemClick: (Forecast) -> Unit

    constructor(weekForecast: ForecastList, itemClick: (Forecast) -> Unit) : super() {
        this.weekForecast = weekForecast
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}