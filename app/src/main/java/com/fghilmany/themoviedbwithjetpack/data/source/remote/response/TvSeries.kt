package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvSeries(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("vote_average")
    var voteAverage: Float = 0f,
    @SerializedName("first_air_date")
    var first_air_date: String = ""
): Parcelable