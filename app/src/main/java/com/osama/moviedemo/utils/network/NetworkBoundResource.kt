package com.osama.moviedemo.utils.network

import com.osama.moviedemo.data.local.db.entity.Movie
import com.osama.moviedemo.data.remote.responses.MovieListResponse


abstract class NetworkBoundResource() {

    suspend fun execute() : MovieListResponse? {
        return if (shouldFetch()){
            val data = loadFromNetwork()
            saveResult(data)
            data
        }else{
            val data = loadFromDb()
            val totalPages = data?.let { it.size/10 } ?: 0
            val totalResults = data?.size ?: 0
            MovieListResponse(page = totalPages,totalPages = totalPages, totalResults = totalResults, movies = data)
        }
    }

    protected abstract suspend fun saveResult(request: MovieListResponse?)

    protected abstract suspend fun loadFromDb(): List<Movie>?

    protected abstract suspend fun loadFromNetwork(): MovieListResponse?

    protected abstract fun shouldFetch(): Boolean

}