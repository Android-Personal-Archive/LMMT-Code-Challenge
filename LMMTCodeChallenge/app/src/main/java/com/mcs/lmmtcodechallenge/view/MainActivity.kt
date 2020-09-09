package com.mcs.lmmtcodechallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcs.lmmtcodechallenge.R
import com.mcs.lmmtcodechallenge.view.adapters.MoviesAdapter
import com.mcs.lmmtcodechallenge.model.pokos.injectables.RetrofitClientSingleton
import com.mcs.lmmtcodechallenge.model.pokos.interfaces.IGetGenresService
import com.mcs.lmmtcodechallenge.model.pokos.interfaces.IGetMoviesService
import com.mcs.lmmtcodechallenge.model.pokos.GenresPOKO
import com.mcs.lmmtcodechallenge.model.pokos.MoviesPOKO
import com.mcs.lmmtcodechallenge.model.pokos.ResultPOKO
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MoviesAdapter.OnMovieItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val genreService = RetrofitClientSingleton.retrofitInstance?.create(IGetGenresService::class.java)
        val genreCall = genreService?.getAllGenres("3c67cd33e32b5d58092ea609cdd9381f")

        val movieService = RetrofitClientSingleton.retrofitInstance?.create(IGetMoviesService::class.java)
        val movieCall = movieService?.getMeMovies("3c67cd33e32b5d58092ea609cdd9381f")

        genreCall?.enqueue(object: Callback<GenresPOKO>{
            override fun onFailure(call: Call<GenresPOKO>, t: Throwable) {
                Log.e("GET Genres", "Call failed.\nCause: ${t.cause}\nMessage: ${t.message}")
            }

            override fun onResponse(call: Call<GenresPOKO>, responseGenre: Response<GenresPOKO>) {
                val resultsGenre = responseGenre.body()
                if(resultsGenre == null)
                {
                    Log.w("GET Genres", "Response returned null")
                }
                else
                {
                    movieCall?.enqueue(object: Callback<MoviesPOKO>{
                        override fun onFailure(call: Call<MoviesPOKO>, t: Throwable) {
                            Log.e("GET Movies", "Call failed.\nCause: ${t.cause}\nMessage: ${t.message}")
                        }

                        override fun onResponse(call: Call<MoviesPOKO>, responseMovie: Response<MoviesPOKO>) {
                            val resultsMovie = responseMovie.body()
                            if(resultsMovie == null)
                            {
                                Log.w("GET Movies", "Response returned null")
                            }
                            else
                            {
                                val adapter = MoviesAdapter(this@MainActivity, resultsGenre, resultsMovie, this@MainActivity)
                                rv_movies.adapter = adapter
                                rv_movies.layoutManager = LinearLayoutManager(this@MainActivity)
                                rv_movies.setHasFixedSize(true)
                            }
                        }
                    })
                }
            }
        })
    }

    override fun onItemClick(movieItem: ResultPOKO, genresItem: GenresPOKO,  position: Int) {
        var intent = Intent(this, DetailsActivity::class.java)

        /*
        intent.putExtra("Extra Detail Movie Data", movieItem)
        intent.putExtra("Extra Detail Genre Data", genresItem)
        */

        startActivity(intent)
    }
}