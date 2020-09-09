package com.mcs.lmmtcodechallenge.model.pokos.interfaces

import com.mcs.lmmtcodechallenge.model.pokos.GenresPOKO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val ENDPOINT_URL = "3/genre/movie/list"
interface IGetGenresService {
    @GET(ENDPOINT_URL)
    fun getAllGenres(@Query("api_key") apiKeyParam: String): Call<GenresPOKO>
}