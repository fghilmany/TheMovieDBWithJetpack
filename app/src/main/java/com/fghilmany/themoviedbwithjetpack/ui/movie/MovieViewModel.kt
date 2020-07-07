package com.fghilmany.themoviedbwithjetpack.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.source.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = dataRepository.getListMovie()
}