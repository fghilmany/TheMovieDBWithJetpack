package com.fghilmany.themoviedbwithjetpack.ui.favorite.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_movie_tv.view.*

class FavoriteMovieAdapter : PagedListAdapter<MovieEntity, FavoriteMovieAdapter.MovieViewHolder>(DIFF_CALLBACK){

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_tv, parent, false)
        return MovieViewHolder(view)
    }

    /*override fun getItemCount(): Int = listMovie.size*/

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null){
            holder.bind(movies)
        }
    }

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind (movie: MovieEntity){
            with(itemView){
                tv_list_title.text = movie.title
                tv_rating.text = movie.voteAverage.toString()
                rating_bar.rating = movie.voteAverage/2
                tv_date.text = "Realease date: " + movie.release_date
                Log.e("CEK_ID", movie.id.toString())
                setOnClickListener {
                    val i = Intent(itemView.context, DetailActivity::class.java)
                    i.putExtra(DetailActivity.EXTRA_ID_MOVIE, movie.id.toString())
                    itemView.context.startActivity(i)
                }
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w780"+movie.posterPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(iv_list)
            }
        }

    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

}