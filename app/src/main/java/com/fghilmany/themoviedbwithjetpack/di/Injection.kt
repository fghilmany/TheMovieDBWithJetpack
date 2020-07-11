package com.fghilmany.themoviedbwithjetpack.di

import android.content.Context
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.LocalDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.local.room.MovieTvDatabase
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): DataRepository {

        val database = MovieTvDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieTvDao())
        val appExecutors = AppExecutors()

        return DataRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}