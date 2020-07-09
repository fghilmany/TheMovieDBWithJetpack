package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_series.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class TvSeriesFragment : Fragment() {

    private val viewModel: TvSeriesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_series, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){

            val movieAdapter = TvSeriesAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getMovies().observe(this, Observer {tv ->
                progress_bar.visibility = View.GONE
                movieAdapter.setMovies(tv)
                movieAdapter.notifyDataSetChanged()
            })

            rv_tv.layoutManager = LinearLayoutManager(context)
            rv_tv.setHasFixedSize(true)
            rv_tv.adapter = movieAdapter

        }
    }


}
