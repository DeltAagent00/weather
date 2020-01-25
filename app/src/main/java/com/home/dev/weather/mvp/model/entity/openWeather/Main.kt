package com.home.dev.weather.mvp.model.entity.openWeather

import java.io.Serializable

data class Main(
    val grnd_level: Double,
    val humidity: Int,
    val pressure: Double,
    val sea_level: Double,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
): Serializable