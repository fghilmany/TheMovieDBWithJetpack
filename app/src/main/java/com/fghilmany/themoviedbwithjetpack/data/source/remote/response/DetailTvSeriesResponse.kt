package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailTvSeriesResponse(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("backdrop_path")
    var backdropPath: String = "",
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("vote_average")
    var voteAverage: Float = 0f,
    @SerializedName("status")
    var status: String = "",
    @SerializedName("number_of_seasons")
    var number_of_seasons: String = "",

    @SerializedName("first_air_date")
    var first_air_date: String = ""
):Parcelable
