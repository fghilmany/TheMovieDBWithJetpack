package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var listMovie: List<MovieEntity> = listOf()
)

