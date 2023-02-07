package com.willy.weather.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.willy.weather.presentation.di.Injector
import com.willy.weather.R
import com.willy.weather.data.model.movie.Movie
import com.willy.weather.databinding.FragmentMovieBinding
import javax.inject.Inject

/**
 * Created by Prashil Sonkusale
 * Email :- sonkusale.prasheel@gmail.com
 * Date :- 27-02-2021
 * Project Name :- WillyWeather_Test
 */

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false)

        ((activity)!!.application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.recyclerViewMovieFragment.layoutManager = LinearLayoutManager(activity)
        adapter = MovieAdapter()
        binding.recyclerViewMovieFragment.adapter = adapter

        displayPopularMovies()
    }

    private fun displayPopularMovies() {

        binding.progressBarMovieFragment.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<Movie>?> = movieViewModel.getMovies()
        activity?.let {
            responseLiveData.observe(it, Observer {

                Log.i(javaClass.simpleName, it.toString())

                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.progressBarMovieFragment.visibility = View.GONE
                } else {
                    binding.progressBarMovieFragment.visibility = View.GONE

                    Toast.makeText(activity, "There is some error...", Toast.LENGTH_LONG).show()
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
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies() {
        binding.progressBarMovieFragment.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarMovieFragment.visibility = View.GONE
            } else {
                binding.progressBarMovieFragment.visibility = View.GONE
            }
        })
    }
}