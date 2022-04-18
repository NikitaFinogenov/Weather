package com.example.weatherapplication.presentation.settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    lateinit var binding: FragmentSettingsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSignout.setOnClickListener {
            findNavController().navigate(R.id.action_nav_settings_to_welcomeFragment)
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val isExpanded = prefs.getBoolean("expanded_weather", false)

        if (isExpanded) binding.switchExpand.isChecked = isExpanded

        binding.switchExpand.setOnCheckedChangeListener { buttonView, isChecked ->
            val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
            prefs.edit()
                .putBoolean("expanded_weather", isChecked)
                .apply()

        }



    }



}












