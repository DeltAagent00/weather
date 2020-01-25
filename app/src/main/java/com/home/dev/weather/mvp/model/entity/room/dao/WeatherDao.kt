package com.home.dev.weather.mvp.model.entity.room.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.home.dev.weather.mvp.model.entity.room.RoomWeather

@Dao
interface WeatherDao {
    @Insert(onConflict = REPLACE)
    fun insert(weather: RoomWeather)

    @Insert(onConflict = REPLACE)
    fun insert(vararg weather: RoomWeather)

    @Insert(onConflict = REPLACE)
    fun insert(weather: List<RoomWeather>)

    @Update
    fun update(weather: RoomWeather)

    @Update
    fun update(vararg weather: RoomWeather)

    @Update
    fun update(weather: List<RoomWeather>)

    @Delete
    fun delete(weather: RoomWeather)

    @Delete
    fun delete(vararg weather: RoomWeather)

    @Delete
    fun delete(weather: List<RoomWeather>)

    @Query("SELECT * FROM roomweather")
    fun getAll(): List<RoomWeather>

    @Query("SELECT * FROM roomweather WHERE city = :city LIMIT 1")
    fun findByCity(city: String): RoomWeather?
}