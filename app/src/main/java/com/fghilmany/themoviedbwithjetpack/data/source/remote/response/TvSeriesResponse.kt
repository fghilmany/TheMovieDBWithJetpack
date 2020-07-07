package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.google.gson.annotations.SerializedName

data class TvSeriesResponse(
    @SerializedName("results")
    var listTvSeries: List<TvSeriesEntity> = listOf()
)

