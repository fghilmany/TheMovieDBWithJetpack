package com.fghilmany.themoviedbwithjetpack.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = dataRepository.getFavoriteMovie()
}