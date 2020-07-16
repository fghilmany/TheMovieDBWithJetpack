package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvSeriesResponse(
    @SerializedName("results")
    var listTvSeries: List<TvSeries> = listOf()
)

