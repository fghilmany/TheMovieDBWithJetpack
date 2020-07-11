package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("results")
    var results: List<Search> = listOf()
)