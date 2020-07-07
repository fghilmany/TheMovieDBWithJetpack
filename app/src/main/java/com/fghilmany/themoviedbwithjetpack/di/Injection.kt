package com.fghilmany.themoviedbwithjetpack.di

import android.content.Context
import com.fghilmany.themoviedbwithjetpack.data.source.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): DataRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return DataRepository.getInstance(remoteDataSource)
    }
}