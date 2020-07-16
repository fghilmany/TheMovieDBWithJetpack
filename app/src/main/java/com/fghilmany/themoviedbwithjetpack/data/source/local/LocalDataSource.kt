package com.fghilmany.themoviedbwithjetpack.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.room.MovieTvDao

class LocalDataSource (private val mMovieTvDao: MovieTvDao){


    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieTvDao.getMovie()

    fun getAllTvSeries(): DataSource.Factory<Int, TvSeriesEntity> = mMovieTvDao.getTvSeries()

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mMovieTvDao.getFavoriteMovie()

    fun getFavoriteTvSeries(): DataSource.Factory<Int, TvSeriesEntity> = mMovieTvDao.getFavoriteTvSeries()

    fun getDetailMovie(idMove: String): LiveData<MovieEntity> = mMovieTvDao.getDetailMovie(idMove)

    fun getDetailTvSeries(idTv: String): LiveData<TvSeriesEntity> = mMovieTvDao.getDetailTvSeries(idTv)

    fun insertMovie(movies: List<MovieEntity>)= mMovieTvDao.insertMovies(movies)

    fun insertTvSeries(tvSeries: List<TvSeriesEntity>) =  mMovieTvDao.insertTvSeries(tvSeries)

    fun insertDetailMovie(movies: MovieEntity)= mMovieTvDao.insertDetailMovie(movies)

    fun insertDetailTv(tvSeries: TvSeriesEntity) =  mMovieTvDao.insertDetailTv(tvSeries)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mMovieTvDao.insertDetailMovie(movie)
    }

    fun setTvFavorite(tvSeries: TvSeriesEntity, newState: Boolean) {
        tvSeries.favorite = newState
        mMovieTvDao.insertDetailTv(tvSeries)
    }
}