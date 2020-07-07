package com.fghilmany.themoviedbwithjetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.source.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse

class DetailViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private lateinit var idMovie : String
    private lateinit var idTvSeries : String

    fun selectedMovie(idMovie:String){
        this.idMovie = idMovie
    }

    fun selectedTvSeries(idTvSeries: String){
        this.idTvSeries = idTvSeries
    }

    fun getDetailMovie() : LiveData<DetailMovieResponse> = dataRepository.getDetailMovie(idMovie)

    fun getDetailTvSeries() : LiveData<DetailTvSeriesResponse> = dataRepository.getDetailTv(idTvSeries)
}