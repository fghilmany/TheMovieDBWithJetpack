package com.fghilmany.themoviedbwithjetpack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.di.Injection
import com.fghilmany.themoviedbwithjetpack.ui.detail.DetailViewModel
import com.fghilmany.themoviedbwithjetpack.ui.movie.MovieViewModel
import com.fghilmany.themoviedbwithjetpack.ui.home.search.SearchViewModel
import com.fghilmany.themoviedbwithjetpack.ui.tvseries.TvSeriesViewModel

class ViewModelFactory private constructor(private val mDataRepository: DataRepository)
    : ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory=
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel (mDataRepository) as T
            }
            modelClass.isAssignableFrom(TvSeriesViewModel::class.java) -> {
                TvSeriesViewModel (mDataRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel (mDataRepository) as T
            }
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                SearchViewModel (mDataRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: "+modelClass.name)
        }
    }
}