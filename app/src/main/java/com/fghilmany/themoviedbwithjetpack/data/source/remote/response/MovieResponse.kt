package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var listMovie: List<Movie> = listOf()
)

