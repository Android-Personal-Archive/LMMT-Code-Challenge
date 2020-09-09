package com.mcs.lmmtcodechallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mcs.lmmtcodechallenge.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        /*
        val movieItem = intent.getParcelableExtra<ResultPOKO>("Extra Detail Movie Data")
        val genresItem = intent.getParcelableExtra<GenresPOKO>("Extra Detail Genre Data")

        tv_title_details.text = movieItem?.title
        tv_release_details.text = "(${movieItem?.releaseDate?.substring(0..3)})"
        tv_popularity_details.text = movieItem?.popularity.toString()

        for(id in movieItem?.genreIds?:emptyList())
        {
            for(genre in genresItem?.genres?: emptyList())
            {
                if(genre.id == id)
                {
                    tv_genres_details.append("${genre.name} |")
                    break
                }
            }
        }
        tv_genres_details.text.trimEnd('|', ' ')

        Picasso.get().load("https://image.tmdb.org/t/p/w500/${movieItem?.posterPath}").into(iv_thumb_details)
        tv_overview_details.text = movieItem?.overview
        */
    }
}