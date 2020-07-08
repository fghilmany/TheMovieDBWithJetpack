package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.SearchEntity
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("results")
    var results: List<SearchEntity> = listOf()
)