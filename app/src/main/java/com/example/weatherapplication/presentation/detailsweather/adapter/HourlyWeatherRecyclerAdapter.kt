package com.example.weatherapplication.presentation.detailsweather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.R
import com.example.weatherapplication.model.data.Hourly
import java.lang.Character.toString
import java.text.SimpleDateFormat
import java.util.*
import java.util.Arrays.toString

class HourlyWeatherRecyclerAdapter(val context: Context, val list: List<Hourly>): RecyclerView.Adapter<HourlyWeatherRecyclerAdapter.HourlyWeatherItemViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherItemViewHolder {
        return HourlyWeatherItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_weather_hourly, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HourlyWeatherItemViewHolder, position: Int) {
        holder.bind(list[position])
    }






    class HourlyWeatherItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Hourly) = with(itemView) {
            val temp = itemView.findViewById<TextView>(R.id.tv_temperature_hourly)
            //val hour = itemView.findViewById<TextView>(R.id.tv_hour)

            val icon = itemView.findViewById<ImageView>(R.id.imageView_weather_hourly)




            temp.text = "${(item.temp-273).toInt()}°"

            when (item.weather[0].main) {
                "Clear" -> icon.setImageDrawable(resources.getDrawable(R.drawable.ic_sunny))
                "Clouds" -> icon.setImageDrawable(resources.getDrawable(R.drawable.ic_partlycloudy))
                "Snow" -> icon.setImageDrawable(resources.getDrawable(R.drawable.ic_snowy))
                "Rain" -> icon.setImageDrawable(resources.getDrawable(R.drawable.ic_rainy))
                "Drizzle" -> icon.setImageDrawable(resources.getDrawable(R.drawable.ic_rainy))
                "Thunderstorm" -> icon.setImageDrawable(resources.getDrawable(R.drawable.ic_rainthunder))

            }
        }

    }


}