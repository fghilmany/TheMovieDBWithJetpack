package com.fghilmany.themoviedbwithjetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tventities")
data class TvSeriesEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "posterPath")
    var posterPath: String = "",

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Float = 0f,

    @ColumnInfo(name = "first_air_date")
    var first_air_date: String = "",

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String = "",

    @ColumnInfo(name = "overview")
    var overview: String = "",

    @ColumnInfo(name = "status")
    var status: String = "",

    @ColumnInfo(name = "number_of_seasons")
    var number_of_seasons: String = "",

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)