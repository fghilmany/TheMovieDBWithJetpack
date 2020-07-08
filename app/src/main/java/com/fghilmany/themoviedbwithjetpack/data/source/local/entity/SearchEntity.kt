package com.fghilmany.themoviedbwithjetpack.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchEntity(
    @SerializedName("id")
    var id : String = "",
    @SerializedName("poster_path")
    var poster_path: String = "",
    @SerializedName("vote_average")
    var vote_average: Float = 0f,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("release_date")
    var release_date: String = "",
    @SerializedName("first_air_date")
    var first_air_date: String = "",
    @SerializedName("media_type")
    var media_type: String = ""
):Parcelable