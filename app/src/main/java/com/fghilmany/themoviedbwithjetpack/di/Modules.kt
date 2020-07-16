package com.fghilmany.themoviedbwithjetpack.di

import androidx.room.Room
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.LocalDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.local.room.MovieTvDatabase
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.ui.detail.DetailViewModel
import com.fghilmany.themoviedbwithjetpack.ui.favorite.movie.FavoriteMovieViewModel
import com.fghilmany.themoviedbwithjetpack.ui.favorite.tvseries.FavoriteTvSeriesViewModel
import com.fghilmany.themoviedbwithjetpack.ui.home.search.SearchViewModel
import com.fghilmany.themoviedbwithjetpack.ui.movie.MovieViewModel
import com.fghilmany.themoviedbwithjetpack.ui.tvseries.TvSeriesViewModel
import com.fghilmany.themoviedbwithjetpack.utils.AppExecutors
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Modules {
    val appModule = module {

        single { DataRepository(get(), get(), get()) }
        single { RemoteDataSource() }
        single { LocalDataSource(get()) }
        single { Room.databaseBuilder(get(), MovieTvDatabase::class.java, "MovieTv").build() }
        single { get<MovieTvDatabase>().movieTvDao() }
        single { AppExecutors() }

        viewModel { MovieViewModel(get()) }
        viewModel { DetailViewModel(get()) }
        viewModel { TvSeriesViewModel(get()) }
        viewModel { SearchViewModel(get()) }
        viewModel { FavoriteMovieViewModel(get()) }
        viewModel { FavoriteTvSeriesViewModel(get()) }
    }
}