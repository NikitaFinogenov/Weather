package com.example.weatherapplication.presentation.detailsweather.dayWeather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.Hourly
import com.example.weatherapplication.model.data.WeatherResponse
import com.example.weatherapplication.model.remote.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DayWeatherViewModel(): ViewModel() {


    val weatherLiveData = MutableLiveData<WeatherResponse>()
    val hourlyWeatherLiveData = MutableLiveData<List<Hourly>>()

    fun fetchWeather(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            weatherLiveData.value = WeatherRepository().fetchWeatherDetails(id)
            Log.d("checkcityid", weatherLiveData.value.toString())
            val lat = weatherLiveData.value!!.coord!!.lat
            val lon = weatherLiveData.value!!.coord!!.lon

            hourlyWeatherLiveData.value = WeatherRepository().getOnecallWeather(lat!!, lon!!).hourly
            Log.d("checkhourlyweather", hourlyWeatherLiveData.value.toString())
        }
    }
}