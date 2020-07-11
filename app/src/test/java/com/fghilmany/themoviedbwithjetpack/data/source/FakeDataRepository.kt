package com.fghilmany.themoviedbwithjetpack.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fghilmany.themoviedbwithjetpack.data.Datasource
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.Movie
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.TvSeries
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse

class FakeDataRepository (private val remoteDataSource: RemoteDataSource):
    Datasource {

    override fun getListMovie(): LiveData<List<Movie>> {

        val movieResults = MutableLiveData<List<Movie>>()
        remoteDataSource.getListMovie(object : RemoteDataSource.GetListMovieCallback{
            override fun onResponse(listMovie: List<Movie>?) {
                movieResults.postValue(listMovie)
            }

            override fun throwbale(t: Throwable) {
                Log.e("ERROR_LIST_MOVIE",t.localizedMessage!!)
            }

        })

        return movieResults

    }

    override fun getListTv(): LiveData<List<TvSeries>> {

        val tvResults = MutableLiveData<List<TvSeries>>()
        remoteDataSource.getListTv(object : RemoteDataSource.GetLisTvCallback {
            override fun onResponse(listTv: List<TvSeries>?) {
                tvResults.postValue(listTv)
                //Log.e(DataRepository::class.java.simpleName, listTv?.get(0)?.name)
            }

            override fun throwbale(t: Throwable) {
                Log.e("ERROR_LIST_MOVIE",t.localizedMessage!!)
            }

        })

        return tvResults

    }

    override fun getDetailTv(idTv: String): LiveData<DetailTvSeriesResponse> {
        val tvDetail = MutableLiveData<DetailTvSeriesResponse>()
        remoteDataSource.getDetailTv(object : RemoteDataSource.GetDetailTvCallback{
            override fun onResponse(detailTv: DetailTvSeriesResponse) {
                tvDetail.postValue(detailTv)
            }

            override fun throwbale(t: Throwable) {
                Log.e("ERROR_LIST_MOVIE",t.localizedMessage!!)
            }

        }, idTv)

        return tvDetail
    }

    override fun getDetailMovie(idMovie: String): LiveData<DetailMovieResponse> {
        val movieDetail = MutableLiveData<DetailMovieResponse>()
        remoteDataSource.getDetailMovie(object : RemoteDataSource.GetDetailMovieCallback{
            override fun onResponse(detailMovie: DetailMovieResponse) {
                movieDetail.postValue(detailMovie)
            }

            override fun throwbale(t: Throwable) {
                Log.e("ERROR_LIST_MOVIE",t.localizedMessage!!)
            }

        }, idMovie)

        return movieDetail

    }

}