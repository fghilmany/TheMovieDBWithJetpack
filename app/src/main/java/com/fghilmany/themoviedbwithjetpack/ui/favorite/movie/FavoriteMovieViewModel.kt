package com.fghilmany.themoviedbwithjetpack.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(dataRepository: DataRepository) : ViewModel() {

    private val movieDataRepository = dataRepository

    fun getMovies(): LiveData<PagedList<MovieEntity>> = movieDataRepository.getFavoriteMovie()

    fun setMovie(movieEntity: MovieEntity){
        val newState = !movieEntity.favorite
        movieDataRepository.setMovieFavorite(movieEntity, newState)
    }
}