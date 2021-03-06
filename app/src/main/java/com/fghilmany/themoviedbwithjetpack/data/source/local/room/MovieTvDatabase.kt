package com.fghilmany.themoviedbwithjetpack.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity


@Database(entities = [MovieEntity::class, TvSeriesEntity::class],
    version = 1,
    exportSchema = false)
abstract class MovieTvDatabase : RoomDatabase() {
    abstract fun movieTvDao(): MovieTvDao

}