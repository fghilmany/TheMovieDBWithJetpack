package com.fghilmany.themoviedbwithjetpack.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.fghilmany.themoviedbwithjetpack.R
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class FavoriteMovieFragment : Fragment() {

    private val viewModel : FavoriteMovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {

            val favoriteAdapter = FavoriteMovieAdapter()
            viewModel.getMovies().observe(this, Observer { movie ->
                if (movie != null){
                    favoriteAdapter.setMovies(movie)
                    favoriteAdapter.notifyDataSetChanged()
                }
            })


            rv_favorite_movie.layoutManager = LinearLayoutManager(context)
            rv_favorite_movie.setHasFixedSize(true)
            rv_favorite_movie.adapter = favoriteAdapter
        }
    }

}
