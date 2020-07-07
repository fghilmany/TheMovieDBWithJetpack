package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_movie_tv.view.*

class TvSeriesAdapter : RecyclerView.Adapter<TvSeriesAdapter.TvViewHolder>(){
    private var listMovie = ArrayList<TvSeriesEntity>()

    fun setMovies(movies: List<TvSeriesEntity>?){
        if (movies == null) return
        listMovie.clear()
        listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_tv, parent, false)
        return TvViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val movies = listMovie[position]
        holder.bind(movies)
    }

    class TvViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind (movie: TvSeriesEntity){
            with(itemView){
                tv_list_title.text = movie.name
                tv_rating.text = movie.voteAverage.toString()
                setOnClickListener {
                    val i = Intent(itemView.context, DetailActivity::class.java)
                    i.putExtra(DetailActivity.EXTRA_ID_TV, movie.id.toString())
                    itemView.context.startActivity(i)
                }
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w780"+movie.backdropPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(iv_list)
            }
        }

    }

}