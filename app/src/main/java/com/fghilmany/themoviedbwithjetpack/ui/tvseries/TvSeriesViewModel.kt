package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.source.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity

class TvSeriesViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovies(): LiveData<List<TvSeriesEntity>> = dataRepository.getListTv()
}