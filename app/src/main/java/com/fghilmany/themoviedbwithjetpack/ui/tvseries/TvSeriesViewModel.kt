package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.MovieEntity
import com.fghilmany.themoviedbwithjetpack.utils.DataDummy

class TvSeriesViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.getDummyTv()
}