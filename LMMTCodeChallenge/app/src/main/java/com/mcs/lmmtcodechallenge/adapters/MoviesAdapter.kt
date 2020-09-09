package com.mcs.lmmtcodechallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mcs.lmmtcodechallenge.R
import com.mcs.lmmtcodechallenge.pokos.GenresPOKO
import com.mcs.lmmtcodechallenge.pokos.MoviesPOKO
import com.mcs.lmmtcodechallenge.pokos.ResultPOKO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MoviesAdapter(context: Context, private val genresDataSet: GenresPOKO, private val moviesDataSet: MoviesPOKO, var clickListener: OnMovieItemClickListener): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    class MoviesViewHolder(movieItemView: View): RecyclerView.ViewHolder(movieItemView){
        val ivThumb: ImageView = movieItemView.iv_thumb
        val tvTitleRelease: TextView = movieItemView.tv_title_release
        val tvGenre: TextView = movieItemView.tv_genre
        val tvScore: TextView = movieItemView.tv_score

        fun initItemClickListener(movieItem: ResultPOKO, genresItem: GenresPOKO, action: OnMovieItemClickListener){
            itemView.setOnClickListener{
                action.onItemClick(movieItem, genresItem, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val miView: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(miView)
    }

    override fun getItemCount(): Int {
        return moviesDataSet.totalResults
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        Picasso.get().load("https://image.tmdb.org/t/p/w300/${moviesDataSet.results[position].backdropPath}").into(holder.ivThumb)
        holder.tvTitleRelease.text = "${moviesDataSet.results[position].title} (${moviesDataSet.results[position].releaseDate.substring(0..3)})"

        for(id in moviesDataSet.results[position].genreIds)
        {
            //search by id in list of genres
            for(genre in genresDataSet.genres)
            {
                if(genre.id == id)
                {
                    holder.tvGenre.append("${genre.name} |")
                    break
                }
            }
        }
        holder.tvGenre.text.trimEnd('|',' ')

        holder.tvScore.text = moviesDataSet.results[position].popularity.toString()
        holder.initItemClickListener(moviesDataSet.results[position], genresDataSet, clickListener)
    }

    interface OnMovieItemClickListener{
        fun onItemClick(movieItem: ResultPOKO, genresItem: GenresPOKO, position: Int)
    }
}