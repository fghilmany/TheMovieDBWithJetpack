package com.fghilmany.themoviedbwithjetpack.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.SearchEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse

class DataRepository private constructor(private val remoteDataSource: RemoteDataSource): Datasource{

    companion object{
        @Volatile
        private var instance : DataRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): DataRepository =
            instance ?: synchronized(this){
                instance ?: DataRepository(remoteDataSource)
            }
    }

    override fun getListMovie(): LiveData<List<MovieEntity>> {

        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getListMovie(object : RemoteDataSource.GetListMovieCallback{
            override fun onResponse(listMovie: List<MovieEntity>?) {
                movieResults.postValue(listMovie)
            }

            override fun throwbale(t: Throwable) {
                Log.e("ERROR_LIST_MOVIE",t.localizedMessage!!)
            }

        })

        return movieResults

    }

    override fun getListTv(): LiveData<List<TvSeriesEntity>> {

        val tvResults = MutableLiveData<List<TvSeriesEntity>>()
        remoteDataSource.getListTv(object : RemoteDataSource.GetLisTvCallback {
            override fun onResponse(listTv: List<TvSeriesEntity>?) {
                Log.e("CEK_VALUE", listTv.toString())
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

    override fun getSearch(query: String): LiveData<List<SearchEntity>> {
        val searchMovie = MutableLiveData<List<SearchEntity>>()
        remoteDataSource.getSearchMovie(object : RemoteDataSource.GetSearchMovieAndTvCallback{
            override fun onResponse(listSearch: List<SearchEntity>?) {
                Log.e("CEK_RESPONSE","INI $listSearch")
                searchMovie.postValue(listSearch)
            }

            override fun throwbale(t: Throwable) {
                Log.e("ERROR_LIST_MOVIE",t.localizedMessage!!)
            }

        }, query)

        return searchMovie
    }


}