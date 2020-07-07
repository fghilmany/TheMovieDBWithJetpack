package com.fghilmany.themoviedbwithjetpack.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvSeriesEntity(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("backdrop_path")
    var backdropPath: String = "",
    @SerializedName("vote_average")
    var voteAverage: Double = 0.0
): Parcelable