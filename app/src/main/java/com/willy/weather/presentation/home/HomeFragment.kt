package com.willy.weather.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.willy.weather.R
import com.willy.weather.databinding.FragmentHomeBinding

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.btnMovie.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
        }

        binding.btnTvShows.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_tvShowsFragment)
        }

        binding.btnArtist.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_artistFragment)
        }

        return binding.root
    }
}