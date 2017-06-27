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
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by LiPin on 2017/6/26 11:16.
 * 描述：
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
                com.squareup.picasso.Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}