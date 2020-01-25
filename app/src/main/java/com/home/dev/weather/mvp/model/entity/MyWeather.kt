package com.home.dev.weather.mvp.model.entity

data class MyWeather(val temp: Double,
                     val humidity: Int,
                     val windSpeed: Double,
                     val pressure: Double,
                     val dt: Long,
                     val pathIcon: String?) {
    override fun toString(): String {
        return "MyWeather(temp=$temp, humidity=$humidity, windSpeed=$windSpeed, pressure=$pressure, dt=$dt, pathIcon=$pathIcon)"
    }
}