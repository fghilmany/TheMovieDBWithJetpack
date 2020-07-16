package com.fghilmany.themoviedbwithjetpack.ui.favorite.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fghilmany.themoviedbwithjetpack.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class FavoriteMovieFragment : Fragment() {

    private val viewModel : FavoriteMovieViewModel by viewModel()
    private lateinit var favoriteAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(rv_favorite_movie)

        if (activity != null) {

            favoriteAdapter = FavoriteMovieAdapter()
            viewModel.getMovies().observe(this, Observer { movie ->
                if (movie != null){
                    Log.e("CEK_LIST+FAV", "ini $movie")
                    favoriteAdapter.submitList(movie)
                    favoriteAdapter.notifyDataSetChanged()

                    rv_favorite_movie.layoutManager = LinearLayoutManager(context)
                    rv_favorite_movie.setHasFixedSize(true)
                    rv_favorite_movie.adapter = favoriteAdapter
                }
            })

        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback(){
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)


        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val swipedPosition = viewHolder.adapterPosition
            val movieEntity = favoriteAdapter.getSwipedData(swipedPosition)
            movieEntity?.let { viewModel.setMovie(it) }

            val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
            snackbar.setAction(R.string.message_ok){ v ->
                movieEntity?.let { viewModel.setMovie(it) }
            }
            snackbar.show()
        }

    })

}
