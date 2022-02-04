package com.osama.moviedemo.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osama.moviedemo.data.local.db.dao.MoviesDao
import com.osama.moviedemo.data.local.db.entity.Movie
import javax.inject.Singleton

@Singleton
@Database(entities = [Movie::class],
        version = 1,
        exportSchema = false)
abstract class DatabaseService : RoomDatabase() {
    abstract fun moviesDao() : MoviesDao

}