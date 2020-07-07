package com.fghilmany.themoviedbwithjetpack.helper

import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.MovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.TvSeriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface{

    @GET("movie/{movieId}")
    fun getDetailMovie(
        @Path("movieId")movieId:String,
        @Query("api_key")apiKey: String
    ): Call<DetailMovieResponse>

    @GET("movie/popular")
    fun getMovieData(
        @Query("api_key")apiKey: String
    ):Call<MovieResponse>

    @GET("tv/{tv_id}")
    fun getDetailTv(
        @Path("tv_id")tvId: String,
        @Query("api_key")apiKey: String
    ):Call<DetailTvSeriesResponse>

    @GET("tv/popular")
    fun getTvData(
        @Query("api_key")apiKey: String
    ):Call<TvSeriesResponse>

}