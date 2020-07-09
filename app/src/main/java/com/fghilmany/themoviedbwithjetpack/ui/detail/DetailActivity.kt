package com.fghilmany.themoviedbwithjetpack.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse
import com.fghilmany.themoviedbwithjetpack.viewmodel.ViewModelFactory
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID_MOVIE = "extra_id_movie"
        const val EXTRA_ID_TV = "extra_id_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val idMovie = extras.getString(EXTRA_ID_MOVIE)
            val idTv = extras.getString(EXTRA_ID_TV)
            Log.e("CEKIDMOVIE",idMovie.toString())
            Log.e("CEKIDTV",idTv.toString())
            if (idMovie != null){
                viewModel.selectedMovie(idMovie)
                viewModel.getDetailMovie().observe(this, Observer {movie ->
                    progress_bar.visibility = View.GONE
                    populateMovie(movie)
                })
            }else{
                if (idTv != null) {
                    viewModel.selectedTvSeries(idTv)
                }
                viewModel.getDetailTvSeries().observe(this, Observer {tv ->
                    progress_bar.visibility = View.GONE
                    populateTvSeries(tv)
                })
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovie(detailMovie: DetailMovieResponse) {
        tv_title.text = detailMovie.title
        tv_overview.text = detailMovie.overview
        tv_seasion.visibility = View.GONE
        tv_status.text = "Status: "+ detailMovie.status
        tv_rating.text = detailMovie.voteAverage.toString()
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w780"+detailMovie.posterPath)
            .apply ( RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .centerCrop()
            .into(iv_poster_detail)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w780"+detailMovie.backdropPath)
            .apply(bitmapTransform(BlurTransformation(5, 3)))
            .into(iv_backdrop)
    }

    @SuppressLint("SetTextI18n")
    private fun populateTvSeries(detailTvSeries: DetailTvSeriesResponse) {
        tv_title.text = detailTvSeries.name
        tv_overview.text = detailTvSeries.overview
        tv_status.text = "Status: "+ detailTvSeries.status
        tv_seasion.text = "Season: "+ detailTvSeries.number_of_seasons
        tv_rating.text = detailTvSeries.voteAverage.toString()
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w780"+detailTvSeries.posterPath)
            .apply ( RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .centerCrop()
            .into(iv_poster_detail)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w780"+detailTvSeries.backdropPath)
            .apply(bitmapTransform(BlurTransformation(5, 1)))
            .into(iv_backdrop)
    }
}
