package com.fghilmany.themoviedbwithjetpack.data

import androidx.lifecycle.LiveData
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.ApiResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.Search
import com.fghilmany.themoviedbwithjetpack.vo.Resource

interface Datasource {

    fun getListMovie(): LiveData<Resource<List<MovieEntity>>>

    fun getListTv(): LiveData<Resource<List<TvSeriesEntity>>>

    fun getDetailTv(idTv: String): LiveData<Resource<TvSeriesEntity>>

    fun getDetailMovie(idMovie: String): LiveData<Resource<MovieEntity>>

    fun getSearch(query: String): LiveData<ApiResponse<List<Search>>>

    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    fun getFavoriteTvSeries(): LiveData<List<TvSeriesEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvSeriesFavorite(tvSeries: TvSeriesEntity, state: Boolean)
}