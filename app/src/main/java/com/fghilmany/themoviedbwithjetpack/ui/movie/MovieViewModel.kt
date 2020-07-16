package com.fghilmany.themoviedbwithjetpack.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.vo.Resource

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = dataRepository.getListMovie()
}