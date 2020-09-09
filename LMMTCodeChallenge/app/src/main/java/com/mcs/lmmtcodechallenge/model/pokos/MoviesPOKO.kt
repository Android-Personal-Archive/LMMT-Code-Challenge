package com.mcs.lmmtcodechallenge.model.pokos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MoviesPOKO(val page: String,
                      @SerializedName("total_results") val totalResults: Int,
                      @SerializedName("total_pages") val totalPages: Int,
                      val results: List<ResultPOKO>)

@Parcelize
data class ResultPOKO(val popularity: Double,
                      @SerializedName("vote_count") val voteCount: Int,
                      val video: Boolean,
                      @SerializedName("poster_path") val posterPath: String,
                      val id: Long,
                      val adult: Boolean,
                      @SerializedName("backdrop_path") val backdropPath: String,
                      val originalLanguage: String,
                      val originalTitle: String,
                      @SerializedName("genre_ids") val genreIds: List<Int>,
                      val title: String,
                      @SerializedName("vote_average") val voteAvg: Double,
                      val overview: String,
                      @SerializedName("release_date") val releaseDate: String) : Parcelable