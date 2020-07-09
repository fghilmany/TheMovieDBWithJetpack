package com.fghilmany.themoviedbwithjetpack.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailMovieResponse(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("backdrop_path")
    var backdropPath: String = "",
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("vote_average")
    var voteAverage: Float = 0f,
    @SerializedName("status")
    var status: String = ""
):Parcelable