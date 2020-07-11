package com.fghilmany.themoviedbwithjetpack.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity

@Dao
interface MovieTvDao {

    @Query("SELECT * FROM movieentities")
    fun getMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where favorite = 1")
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tventities")
    fun getTvSeries(): LiveData<List<TvSeriesEntity>>

    @Query("SELECT * FROM tventities where favorite = 1")
    fun getFavoriteTvSeries(): LiveData<List<TvSeriesEntity>>

    @Query("SELECT * FROM movieentities where id = :movieId")
    fun getDetailMovie(movieId: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tventities where id = :tvSeriesId")
    fun getDetailTvSeries(tvSeriesId: String): LiveData<TvSeriesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvSeries(tvSeries: List<TvSeriesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTv(tvSeries: TvSeriesEntity)

    //database detail harus di ubah


}