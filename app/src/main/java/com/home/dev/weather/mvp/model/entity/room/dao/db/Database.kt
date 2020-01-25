package com.home.dev.weather.mvp.model.entity.room.dao.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.home.dev.weather.mvp.model.entity.room.RoomWeather
import com.home.dev.weather.mvp.model.entity.room.dao.WeatherDao

@Database(entities = [RoomWeather::class], version = 1)
abstract class Database: RoomDatabase() {
    companion object {
        const val DB_NAME = "weatherDatabase.db"
    }
    abstract fun getWeatherDao(): WeatherDao
}