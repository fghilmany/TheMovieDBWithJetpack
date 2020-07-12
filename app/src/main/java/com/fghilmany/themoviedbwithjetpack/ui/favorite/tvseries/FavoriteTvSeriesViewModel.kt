package com.fghilmany.themoviedbwithjetpack.ui.favorite.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity

class FavoriteTvSeriesViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovies(): LiveData<PagedList<TvSeriesEntity>> = dataRepository.getFavoriteTvSeries()

    fun setMovie(tvSeriesEntity: TvSeriesEntity){
        val newState = !tvSeriesEntity.favorite
        dataRepository.setTvSeriesFavorite(tvSeriesEntity, newState)
    }
}