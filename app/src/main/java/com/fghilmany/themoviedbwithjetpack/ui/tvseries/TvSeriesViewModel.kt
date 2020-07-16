package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.vo.Resource

class TvSeriesViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<TvSeriesEntity>>> = dataRepository.getListTv()
}