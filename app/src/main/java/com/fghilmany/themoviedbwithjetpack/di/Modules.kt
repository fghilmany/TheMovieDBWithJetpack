package com.fghilmany.themoviedbwithjetpack.di

import com.fghilmany.themoviedbwithjetpack.data.source.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.ui.detail.DetailViewModel
import com.fghilmany.themoviedbwithjetpack.ui.home.search.SearchViewModel
import com.fghilmany.themoviedbwithjetpack.ui.movie.MovieViewModel
import com.fghilmany.themoviedbwithjetpack.ui.tvseries.TvSeriesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Modules {
    val appModule = module {

        single{ DataRepository(get()) }
        single { RemoteDataSource() }

        viewModel { MovieViewModel(get()) }
        viewModel { DetailViewModel(get()) }
        viewModel { TvSeriesViewModel(get()) }
        viewModel { SearchViewModel(get()) }
    }
}