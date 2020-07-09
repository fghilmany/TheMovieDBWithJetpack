package com.fghilmany.themoviedbwithjetpack.ui.home.search

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.SearchEntity
import com.fghilmany.themoviedbwithjetpack.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_movie_tv.view.*

class SearchAdapter  : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){
    private var listMovie = ArrayList<SearchEntity>()

    fun setMovies(movies: List<SearchEntity>?){
        if (movies == null) return
        listMovie.clear()
        listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_tv, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val movies = listMovie[position]
        holder.bind(movies)
    }

    class SearchViewHolder(view: View): RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind (search: SearchEntity){
            with(itemView){
                if (search.title != ""){
                    tv_list_title.text = search.title
                }else{
                    tv_list_title.text = search.name
                }

                tv_rating.text = search.vote_average.toString()
                rating_bar.rating = search.vote_average/2
                if (search.first_air_date == ""){
                    tv_date.text = "Realease date: " + search.release_date
                }else{
                    tv_date.text = "First air date: " + search.first_air_date
                }
                setOnClickListener {
                    val i = Intent(itemView.context, DetailActivity::class.java)
                    if (search.media_type != "tv"){
                        i.putExtra(DetailActivity.EXTRA_ID_MOVIE, search.id)
                    }else{
                        i.putExtra(DetailActivity.EXTRA_ID_TV, search.id)
                    }
                    itemView.context.startActivity(i)

                }
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w780"+search.poster_path)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(iv_list)
            }
        }

    }

}