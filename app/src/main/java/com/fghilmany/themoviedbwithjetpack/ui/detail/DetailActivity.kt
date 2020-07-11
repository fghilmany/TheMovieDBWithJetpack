package com.fghilmany.themoviedbwithjetpack.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.vo.Status
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private var state: Boolean = false

    companion object{
        const val EXTRA_ID_MOVIE = "extra_id_movie"
        const val EXTRA_ID_TV = "extra_id_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extras = intent.extras
        if (extras != null){
            val idMovie = extras.getString(EXTRA_ID_MOVIE)
            val idTv = extras.getString(EXTRA_ID_TV)
            progress_bar.visibility = View.VISIBLE
            if (idMovie != null){
                viewModel.selectedMovie(idMovie)
                viewModel.getDetailMovie.observe(this, Observer {movie ->
                    if (movie != null){
                        when (movie.status){
                            Status.LOADING -> progress_bar.visibility = View.VISIBLE
                            Status.SUCCESS ->{
                                progress_bar.visibility = View.GONE
                                populateMovie(movie.data!!)
                                state = movie.data.favorite
                                Log.e("CEK_FAV_STATUS1", state.toString())
                                setFavoriteState(state)


                            }
                            Status.ERROR -> {
                                progress_bar.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }
                })

                btn_favorite.setOnClickListener {
                    Log.e("CEK_FAV_STATUS1", state.toString())
                    if (state) {
                        Log.e("CEK_FAV_STATUS2", state.toString())
                        viewModel.setFavoriteMovie()
                        btn_favorite.text = resources.getText(R.string.remove_from_favorite)
                        btn_favorite.icon = ContextCompat.getDrawable(this, R.drawable.ic_remove)
                    }else{
                        Log.e("CEK_FAV_STATUS2", state.toString())
                        viewModel.setFavoriteMovie()
                        btn_favorite.text = resources.getText(R.string.add_to_favorite)
                        btn_favorite.icon = ContextCompat.getDrawable(this, R.drawable.ic_add)
                    }
                }
            }else{
                if (idTv != null) {
                    viewModel.selectedTvSeries(idTv)
                    viewModel.getDetailTvSeries.observe(this, Observer {tv ->
                        if (tv != null){
                            when (tv.status){
                                Status.LOADING -> progress_bar.visibility = View.VISIBLE
                                Status.SUCCESS ->{
                                    progress_bar.visibility = View.GONE
                                    populateTvSeries(tv.data!!)
                                    state = tv.data.favorite
                                    setFavoriteState(state)
                                }
                                Status.ERROR -> {
                                    progress_bar.visibility = View.GONE
                                    Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                }

                            }
                        }
                    })
                    btn_favorite.setOnClickListener {
                        if (state) {
                            viewModel.setFavoriteTvSeries()
                            btn_favorite.text = resources.getText(R.string.remove_from_favorite)
                            btn_favorite.icon = ContextCompat.getDrawable(this, R.drawable.ic_remove)
                        }else{
                            viewModel.setFavoriteTvSeries()
                            btn_favorite.text = resources.getText(R.string.add_to_favorite)
                            btn_favorite.icon = ContextCompat.getDrawable(this, R.drawable.ic_add)
                        }
                    }
                }
            }
        }
    }

    private fun setFavoriteState(state: Boolean){
        Log.e("CEK_TEXT", state.toString())

        if (state){
            btn_favorite.text = resources.getText(R.string.remove_from_favorite)
            btn_favorite.icon = ContextCompat.getDrawable(this, R.drawable.ic_remove)
        }else{
            btn_favorite.text = resources.getText(R.string.add_to_favorite)
            btn_favorite.icon = ContextCompat.getDrawable(this, R.drawable.ic_add)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovie(detailMovie: MovieEntity) {
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
    private fun populateTvSeries(detailTvSeries: TvSeriesEntity) {
        tv_title.text = detailTvSeries.name
        tv_overview.text = detailTvSeries.overview
        tv_status.text = "Status: "+ detailTvSeries.status
        tv_seasion.text = "Season: "+ detailTvSeries.number_of_seasons
        tv_rating.text = detailTvSeries.voteAverage.toString()
        Log.e("CEK_BACKFROP", "ini"+detailTvSeries.backdropPath)
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
