package com.mcs.lmmtcodechallenge.model.pokos.interfaces

import com.mcs.lmmtcodechallenge.model.pokos.MoviesPOKO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val ENDPOINT_URL = "3/movie/popular"
interface IGetMoviesService {
    @GET(ENDPOINT_URL)
    fun getMeMovies(@Query("api_key") apiKeyParam: String): Call<MoviesPOKO>
}