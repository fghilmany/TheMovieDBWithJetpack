package com.fghilmany.themoviedbwithjetpack.ui.favorite.tvseries

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite_tv_series.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class FavoriteTvSeriesFragment : Fragment() {

    private val viewModel : FavoriteTvSeriesViewModel by viewModel()
    private lateinit var favoriteAdapter: FavoriteTvSeriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_series, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(rv_favorite_tv)
        if (activity != null) {

            favoriteAdapter = FavoriteTvSeriesAdapter()
            viewModel.getMovies().observe(this, Observer { movie ->
                if (movie != null){

                    favoriteAdapter.submitList(movie)
                    Log.e("CEKFAVORITE","${favoriteAdapter.submitList(movie)}")
                    Log.e("CEKFAVORITE","${movie}")
//                    favoriteAdapter.notifyDataSetChanged()
                    rv_favorite_tv.layoutManager = LinearLayoutManager(context)
                    rv_favorite_tv.setHasFixedSize(true)
                    rv_favorite_tv.adapter = favoriteAdapter
                }
            })

            //favoriteAdapter = FavoriteTvSeriesAdapter()

          /*  viewModel.getMovies().observe(this, observerTv)
            Log.e("CEKCEK", "${viewModel.getMovies().observe(this, observerTv)}")
            Log.e("CEKCEK", "$observerTv")*/
        }
    }

  /*  private val observerTv = Observer<PagedList<TvSeriesEntity>> {
        favoriteAdapter.submitList(it)
    }
*/
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
