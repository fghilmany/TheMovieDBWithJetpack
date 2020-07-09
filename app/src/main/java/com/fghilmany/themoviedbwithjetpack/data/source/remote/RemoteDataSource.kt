package com.fghilmany.themoviedbwithjetpack.data.source.remote

import android.util.Log
import com.fghilmany.themoviedbwithjetpack.BuildConfig
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.SearchEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.*
import com.fghilmany.themoviedbwithjetpack.helper.ApiClient
import com.fghilmany.themoviedbwithjetpack.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource{
    companion object{

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource()
            }
    }

    private val retrofit = ApiClient().create()

    fun getListMovie(getListMovieCallback : GetListMovieCallback){
        EspressoIdlingResource.increment()
        retrofit.getMovieData(BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    getListMovieCallback.throwbale(t)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.let { getListMovieCallback.onResponse(response.body()?.listMovie) }
                    EspressoIdlingResource.decrement()
                }

            })

    }

    fun getListTv(getListTvCallback : GetLisTvCallback){
        EspressoIdlingResource.increment()
        retrofit.getTvData(BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<TvSeriesResponse> {
                override fun onFailure(call: Call<TvSeriesResponse>, t: Throwable) {
                    getListTvCallback.throwbale(t)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<TvSeriesResponse>,
                    response: Response<TvSeriesResponse>
                ) {
                    response.body()?.let { getListTvCallback.onResponse(response.body()?.listTvSeries) }
                    Log.e("CEK_VAL_FROM_RETRO", "${response.body()?.let { getListTvCallback.onResponse(response.body()?.listTvSeries)} }")
                    EspressoIdlingResource.decrement()
                }

            })

    }

    fun getDetailMovie(getDetailMovieCallback : GetDetailMovieCallback, idMovie: String){
        EspressoIdlingResource.increment()
        retrofit.getDetailMovie(idMovie, BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<DetailMovieResponse> {
                override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                    getDetailMovieCallback.throwbale(t)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>
                ) {
                    response.body()?.let { getDetailMovieCallback.onResponse(response.body()!!) }
                    EspressoIdlingResource.decrement()
                }

            })

    }

    fun getDetailTv(getDetailTvCallback: GetDetailTvCallback, idTv: String){
        EspressoIdlingResource.increment()
        retrofit.getDetailTv(idTv, BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<DetailTvSeriesResponse> {
                override fun onFailure(call: Call<DetailTvSeriesResponse>, t: Throwable) {
                    getDetailTvCallback.throwbale(t)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<DetailTvSeriesResponse>,
                    response: Response<DetailTvSeriesResponse>
                ) {
                    response.body()?.let { getDetailTvCallback.onResponse(response.body()!!) }
                    EspressoIdlingResource.decrement()
                }

            })

    }

    fun getSearchMovie(getSearchCallback: GetSearchMovieAndTvCallback, query: String){
        EspressoIdlingResource.increment()
        retrofit.getSearchMovieAndTv(BuildConfig.TMDB_API_KEY, query)
            .enqueue(object : Callback<SearchResponse>{
                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    getSearchCallback.throwbale(t)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
                ) {
                    Log.e("CEK_RESPONSE_RETRO","INI ${response.body()}")
                    response.body()?.let { getSearchCallback.onResponse(response.body()?.results) }
                    EspressoIdlingResource.decrement()
                }

            })
    }

    interface GetListMovieCallback {
        fun onResponse(listMovie: List<MovieEntity>?)
        fun throwbale(t: Throwable)
    }

    interface GetLisTvCallback {
        fun onResponse(listTv: List<TvSeriesEntity>?)
        fun throwbale(t: Throwable)
    }

    interface GetDetailMovieCallback {
        fun onResponse(detailMovie: DetailMovieResponse)
        fun throwbale(t: Throwable)
    }

    interface GetDetailTvCallback {
        fun onResponse(detailTv: DetailTvSeriesResponse)
        fun throwbale(t: Throwable)
    }

    interface GetSearchMovieAndTvCallback {
        fun onResponse(listSearch: List<SearchEntity>?)
        fun throwbale(t: Throwable)
    }
}