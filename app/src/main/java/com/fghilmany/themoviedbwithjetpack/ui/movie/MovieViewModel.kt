package com.fghilmany.themoviedbwithjetpack.ui.movie

import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.MovieEntity
import com.fghilmany.themoviedbwithjetpack.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.getDummyMovie()
}