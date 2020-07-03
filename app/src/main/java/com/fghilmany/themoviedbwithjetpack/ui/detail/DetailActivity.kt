package com.fghilmany.themoviedbwithjetpack.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.MovieEntity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val idMovie = extras.getString(EXTRA_ID)
            if (idMovie != null){
                viewModel.selectedMovie(idMovie)
                populateMovie(viewModel.getDetailMovie())
            }
        }
    }

    private fun populateMovie(detailMovie: MovieEntity) {
        tv_title.text = detailMovie.title
        tv_overview.text = detailMovie.overview
        Glide.with(this)
            .load(detailMovie.imagePath)
            .centerCrop()
            .into(iv_poster_detail)
    }
}
