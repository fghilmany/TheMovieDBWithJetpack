package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import android.os.Parcelable
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MovieResponse(
    @SerializedName("results")
    var listMovie: List<MovieEntity> = listOf()
)

