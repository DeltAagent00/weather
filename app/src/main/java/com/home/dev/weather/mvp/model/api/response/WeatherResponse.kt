package com.home.dev.weather.mvp.model.api.response

import com.home.dev.weather.mvp.model.entity.openWeather.*
import java.io.Serializable

data class WeatherResponse(
    val coord: Coord,
    val weather: Collection<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
): Serializable