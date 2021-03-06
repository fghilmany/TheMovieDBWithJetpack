package com.fghilmany.themoviedbwithjetpack.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fghilmany.themoviedbwithjetpack.BuildConfig
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.*
import com.fghilmany.themoviedbwithjetpack.helper.ApiClient
import com.fghilmany.themoviedbwithjetpack.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource{

    private val retrofit = ApiClient().create()

    fun getListMovie(): LiveData<ApiResponse<List<Movie>>>{
        val resultMovie = MutableLiveData<ApiResponse<List<Movie>>>()
        EspressoIdlingResource.increment()
        retrofit.getMovieData(BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    resultMovie.value = ApiResponse.success(response.body()!!.listMovie)
                    EspressoIdlingResource.decrement()
                }

            })
        return resultMovie

    }

    fun getListTv(): LiveData<ApiResponse<List<TvSeries>>>{
        val resultTvSeries = MutableLiveData<ApiResponse<List<TvSeries>>>()
        EspressoIdlingResource.increment()
        retrofit.getTvData(BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<TvSeriesResponse> {
                override fun onFailure(call: Call<TvSeriesResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<TvSeriesResponse>,
                    response: Response<TvSeriesResponse>
                ) {
                    resultTvSeries.value = ApiResponse.success(response.body()!!.listTvSeries)
                    EspressoIdlingResource.decrement()
                }

            })
        return resultTvSeries

    }

    fun getDetailMovie( idMovie: String): LiveData<ApiResponse<DetailMovieResponse>>{
        val resulrDetailMovie = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        EspressoIdlingResource.increment()
        retrofit.getDetailMovie(idMovie, BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<DetailMovieResponse> {
                override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>
                ) {
                    resulrDetailMovie.value = ApiResponse.success(response.body()!!)
                    EspressoIdlingResource.decrement()
                }

            })
        return resulrDetailMovie

    }

    fun getDetailTv(idTv: String): LiveData<ApiResponse<DetailTvSeriesResponse>>{
        val resultDetailTv = MutableLiveData<ApiResponse<DetailTvSeriesResponse>>()
        EspressoIdlingResource.increment()
        retrofit.getDetailTv(idTv, BuildConfig.TMDB_API_KEY)
            .enqueue(object : Callback<DetailTvSeriesResponse> {
                override fun onFailure(call: Call<DetailTvSeriesResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<DetailTvSeriesResponse>,
                    response: Response<DetailTvSeriesResponse>
                ) {
                    resultDetailTv.value = ApiResponse.success(response.body()!!)
                    EspressoIdlingResource.decrement()
                }

            })
        return resultDetailTv

    }

    fun getSearchMovie( query: String): LiveData<ApiResponse<List<Search>>>{
        val resultSearch = MutableLiveData<ApiResponse<List<Search>>>()
        EspressoIdlingResource.increment()
        retrofit.getSearchMovieAndTv(BuildConfig.TMDB_API_KEY, query)
            .enqueue(object : Callback<SearchResponse>{
                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
                ) {
                    if (response.body() != null){
                        resultSearch.value = ApiResponse.success(response.body()!!.results)
                    }
                    EspressoIdlingResource.decrement()
                }

            })

        return resultSearch
    }

}