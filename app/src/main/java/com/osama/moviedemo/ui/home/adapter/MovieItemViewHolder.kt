package com.osama.moviedemo.ui.home.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osama.moviedemo.R
import com.osama.moviedemo.data.local.db.entity.Movie
import com.osama.moviedemo.databinding.CustomMovieRowBinding
import com.osama.moviedemo.utils.common.Constants

class MovieItemViewHolder(private val view : View, private val onClick: (Movie,ImageView) -> Unit) : RecyclerView.ViewHolder(view) {


     fun bind(movie : Movie) {
        val binding : CustomMovieRowBinding =
            CustomMovieRowBinding.bind(view)

        binding.apply {
            movieName.text = movie.title
            movieRating.text = itemView.context.getString(R.string.averageVote,movie.vote_average.toString())
            movieOverview.text = movie.overview
            movieReleaseDate.text = itemView.context.getString(R.string.releaseDate,movie.releaseDate)

            val glideRequest = Glide
                .with(binding.movieImage.context)
                .load(Constants.IMAGE_BASE_URL+movie.poster_path)
            glideRequest.into(binding.movieImage)
        }



        itemView.setOnClickListener {
            onClick(movie,binding.movieImage)
        }


    }




}