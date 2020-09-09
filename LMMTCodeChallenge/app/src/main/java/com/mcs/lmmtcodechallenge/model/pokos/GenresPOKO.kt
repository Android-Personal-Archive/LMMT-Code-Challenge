package com.mcs.lmmtcodechallenge.model.pokos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenresPOKO(val genres: List<GenrePOKO>) : Parcelable

@Parcelize
data class GenrePOKO(val id: Int, val name: String) : Parcelable