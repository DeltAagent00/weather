package com.home.dev.weather.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomWeather(
    @PrimaryKey
    val city: String,
    val temp: Double,
    val humidity: Int,
    val windSpeed: Double,
    val pressure: Double,
    val dt: Long,
    val pathIcon: String?)