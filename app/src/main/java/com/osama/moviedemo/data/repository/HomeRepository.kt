package com.osama.moviedemo.data.repository

import com.osama.moviedemo.data.local.db.DatabaseService
import com.osama.moviedemo.data.local.db.entity.Movie
import com.osama.moviedemo.data.remote.NetworkService
import com.osama.moviedemo.data.remote.responses.MovieListResponse
import com.osama.moviedemo.utils.network.NetworkBoundResource
import com.osama.moviedemo.utils.network.NetworkHelper
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService,
    private val networkHelper: NetworkHelper
){

    suspend fun fetchMovies(page : Int) : MovieListResponse? {

        return object : NetworkBoundResource(){

            override suspend fun saveResult(request: MovieListResponse?) {
                databaseService.moviesDao().insertMoves(request?.movies!!)
            }

            override suspend fun loadFromDb(): List<Movie> {
                return databaseService.moviesDao().getMovies()
            }

            override suspend fun loadFromNetwork(): MovieListResponse {
                return networkService.getPopularMovies(page = page)
            }

            override fun shouldFetch(): Boolean {
                return networkHelper.isNetworkConnected()
            }


        }.execute()


    }

}