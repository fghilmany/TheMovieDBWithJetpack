package com.fghilmany.themoviedbwithjetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.vo.Resource

class DetailViewModel(private val dataRepository: DataRepository) : ViewModel() {

    var idMovie  = MutableLiveData<String>()
    var idTvSeries  = MutableLiveData<String>()

    fun selectedMovie(idMovie:String){
        this.idMovie.value = idMovie
    }

    fun selectedTvSeries(idTvSeries: String){
        this.idTvSeries.value = idTvSeries
    }

    var getDetailMovie : LiveData<Resource<MovieEntity>> = Transformations.switchMap(idMovie){ idMovie ->
        dataRepository.getDetailMovie(idMovie)
    }

    var getDetailTvSeries : LiveData<Resource<TvSeriesEntity>> = Transformations.switchMap(idTvSeries){ idTvSeries ->
        dataRepository.getDetailTv(idTvSeries)
    }


    fun setFavoriteMovie() {
        val movieResource = getDetailMovie.value
        if (movieResource != null){
            val movie = movieResource.data
            if (movie != null){
                val newState = !movie.favorite
                dataRepository.setMovieFavorite(movie, newState)
            }
        }
    }

    fun setFavoriteTvSeries() {
        val tvResource = getDetailTvSeries.value
        if (tvResource != null){
            val tvSeries = tvResource.data

            if (tvSeries != null){
                val newState = !tvSeries.favorite
                dataRepository.setTvSeriesFavorite(tvSeries, newState)
            }
        }
    }
}