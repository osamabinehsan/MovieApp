package com.osama.moviedemo.data.remote.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.osama.moviedemo.data.local.db.entity.Movie

data class MovieListResponse (
        @SerializedName("page")
        @Expose
        val page:Int,

        @SerializedName("total_results")
        @Expose
        val totalResults: Int,

        @SerializedName("total_pages")
        @Expose
        val totalPages: Int,

        @SerializedName("results")
        @Expose
        val movies: List<Movie>?
)

