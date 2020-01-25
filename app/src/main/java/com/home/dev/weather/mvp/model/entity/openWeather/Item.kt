package com.home.dev.weather.mvp.model.entity.openWeather

import java.io.Serializable

data class Item(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
): Serializable