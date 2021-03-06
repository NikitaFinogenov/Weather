package com.example.weatherapplication.presentation.weather

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.example.weatherapplication.R
import com.example.weatherapplication.presentation.weather.adapters.WeatherAdapter1
import com.example.weatherapplication.databinding.FragmentWeatherListBinding

class WeatherListFragment : Fragment() {

    lateinit var binding: FragmentWeatherListBinding
    lateinit var viewModel: WeatherListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val test = prefs.getBoolean("expanded_weather", false)
        Toast.makeText(requireContext(), test.toString(), Toast.LENGTH_SHORT).show()
        viewModel.fetchWeather()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_list, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(WeatherListViewModel::class.java)


        viewModel.weatherList.observe(viewLifecycleOwner) {
            val weatherAdapter = WeatherAdapter1(requireContext(), it)
            binding.rvWeather.adapter = weatherAdapter
        }
    }
}