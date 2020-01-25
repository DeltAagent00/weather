package com.home.dev.weather.mvp.model.entity.openWeather

import java.io.Serializable

data class Wind(
    val deg: Double,
    val speed: Double
): Serializable