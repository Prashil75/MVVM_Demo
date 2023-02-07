package com.willy.weather.presentation.artist

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.willy.weather.R
import com.willy.weather.databinding.FragmentArtistBinding
import com.willy.weather.presentation.HomeActivity
import com.willy.weather.presentation.di.Injector
import javax.inject.Inject


/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class ArtistFragment : Fragment() {

    private lateinit var binding: FragmentArtistBinding

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist, container, false)
        ((activity)!!.application as Injector).createArtistSubComponent()
            .inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        initRecyclerView()
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun initRecyclerView() {
        binding.recyclerViewArtistFragment.layoutManager = LinearLayoutManager(activity)
        artistAdapter = ArtistAdapter()
        binding.recyclerViewArtistFragment.adapter = artistAdapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.progressBarArtistFragment.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.progressBarArtistFragment.visibility = View.GONE
            } else {
                binding.progressBarArtistFragment.visibility = View.GONE
                Toast.makeText(activity, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater = inflater
        inflater.inflate(R.menu.update, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShows() {
        binding.progressBarArtistFragment.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this, Observer {
            if (it != null) {
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.progressBarArtistFragment.visibility = View.GONE
            } else {
                binding.progressBarArtistFragment.visibility = View.GONE
            }
        })
    }
}