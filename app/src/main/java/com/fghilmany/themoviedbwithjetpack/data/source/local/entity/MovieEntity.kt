package com.fghilmany.themoviedbwithjetpack.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("vote_average")
    var voteAverage: Float = 0f,
    @SerializedName("release_date")
    var release_date: String = ""
):Parcelable