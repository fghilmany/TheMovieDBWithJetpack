package com.fghilmany.themoviedbwithjetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.MovieEntity
import com.fghilmany.themoviedbwithjetpack.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var idMovie : String

    fun selectedMovie(idMovie:String){
        this.idMovie = idMovie
    }

    fun getDetailMovie() : MovieEntity {
        lateinit var movie : MovieEntity
        val listMovie = ArrayList<MovieEntity>()
        listMovie.addAll(DataDummy.getDummyMovie())
        listMovie.addAll(DataDummy.getDummyTv())
        for (movieEntity in listMovie){
            if (movieEntity.movieId == idMovie){
                movie = movieEntity
            }
        }
        return movie
    }
}