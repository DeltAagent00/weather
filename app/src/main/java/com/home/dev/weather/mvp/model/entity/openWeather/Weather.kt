package com.home.dev.weather.mvp.model.entity.openWeather

import java.io.Serializable

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
): Serializable