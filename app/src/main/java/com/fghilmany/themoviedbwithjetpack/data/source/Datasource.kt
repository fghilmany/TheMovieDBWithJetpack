package com.fghilmany.themoviedbwithjetpack.data.source

import androidx.lifecycle.LiveData
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse

interface Datasource {

    fun getListMovie(): LiveData<List<MovieEntity>>

    fun getListTv(): LiveData<List<TvSeriesEntity>>

    fun getDetailTv(idTv: String): LiveData<DetailTvSeriesResponse>

    fun getDetailMovie(idMovie: String): LiveData<DetailMovieResponse>
}