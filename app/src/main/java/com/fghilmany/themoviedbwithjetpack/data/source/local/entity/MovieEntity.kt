package com.fghilmany.themoviedbwithjetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "posterPath")
    var posterPath: String = "",

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Float = 0f,

    @ColumnInfo(name = "release_date")
    var release_date: String = "",

    @ColumnInfo(name = "backdrop_path")
    var backdropPath: String = "",

    @ColumnInfo(name = "overview")
    var overview: String = "",

    @ColumnInfo(name = "status")
    var status: String = "",

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)