package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_movie_tv.view.*

class TvSeriesAdapter internal constructor():PagedListAdapter<TvSeriesEntity, TvSeriesAdapter.TvViewHolder>(DIFF_CALLBACK){
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvSeriesEntity>() {
            override fun areItemsTheSame(oldItem: TvSeriesEntity, newItem: TvSeriesEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: TvSeriesEntity, newItem: TvSeriesEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_tv, parent, false)
        return TvViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null){
            holder.bind(movies)
        }
    }

    class TvViewHolder(view: View): RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind (movie: TvSeriesEntity){
            with(itemView){
                tv_list_title.text = movie.name
                tv_rating.text = movie.voteAverage.toString()
                rating_bar.rating = (movie.voteAverage/2)
                tv_date.text ="First air date: " + movie.first_air_date
                setOnClickListener {
                    val i = Intent(itemView.context, DetailActivity::class.java)
                    i.putExtra(DetailActivity.EXTRA_ID_TV, movie.id.toString())
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

}