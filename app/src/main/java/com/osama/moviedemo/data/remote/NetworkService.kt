package com.osama.moviedemo.data.remote

import com.osama.moviedemo.data.remote.responses.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface NetworkService {
    @GET(EndPoints.discover_movie)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = Networking.API_KEY,
        @Query("page") page: Int
    ): MovieListResponse

}