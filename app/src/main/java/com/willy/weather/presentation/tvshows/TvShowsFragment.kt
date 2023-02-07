package com.willy.weather.presentation.tvshows

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.willy.weather.presentation.di.Injector
import com.willy.weather.R
import com.willy.weather.databinding.FragmentTvShowsBinding
import javax.inject.Inject

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class TvShowsFragment : Fragment() {

    private lateinit var binding: FragmentTvShowsBinding

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv_shows, container, false)

        ((activity)!!.application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.recyclerViewTvShowFragment.layoutManager = LinearLayoutManager(activity)
        adapter = TvAdapter()
        binding.recyclerViewTvShowFragment.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.progressBarTvShowFragment.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        activity?.let {
            responseLiveData.observe(it, Observer {
                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.progressBarTvShowFragment.visibility = View.GONE
                } else {
                    binding.progressBarTvShowFragment.visibility = View.GONE
                    Toast.makeText(activity, "No data available", Toast.LENGTH_LONG)
                        .show()
                }
            })
        }
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
        binding.progressBarTvShowFragment.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarTvShowFragment.visibility = View.GONE
            } else {
                binding.progressBarTvShowFragment.visibility = View.GONE
            }
        })
    }
}