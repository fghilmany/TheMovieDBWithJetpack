package com.fghilmany.themoviedbwithjetpack.ui.home.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    companion object {
        val TAG = SearchFragment::class.java.simpleName

        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), factory)[SearchViewModel::class.java]

            val  searchAdapter = SearchAdapter()
            viewModel.getMovies().observe(this, Observer { movie ->
                searchAdapter.setMovies(movie)
                searchAdapter.notifyDataSetChanged()
            })
            rv_search.layoutManager = LinearLayoutManager(activity?.applicationContext)
            rv_search.setHasFixedSize(true)
            rv_search.adapter = searchAdapter

        }
    }


}
