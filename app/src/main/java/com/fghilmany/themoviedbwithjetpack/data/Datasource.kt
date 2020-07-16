package com.fghilmany.themoviedbwithjetpack.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.ApiResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.Search
import com.fghilmany.themoviedbwithjetpack.vo.Resource

interface Datasource {

    fun getListMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getListTv(): LiveData<Resource<PagedList<TvSeriesEntity>>>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvSeries(): LiveData<PagedList<TvSeriesEntity>>

    fun getDetailTv(idTv: String): LiveData<Resource<TvSeriesEntity>>

    fun getDetailMovie(idMovie: String): LiveData<Resource<MovieEntity>>

    fun getSearch(query: String): LiveData<ApiResponse<List<Search>>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvSeriesFavorite(tvSeries: TvSeriesEntity, state: Boolean)
}