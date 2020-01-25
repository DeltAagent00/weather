package com.home.dev.weather.mvp.model.entity

import com.home.dev.weather.mvp.model.api.response.WeatherResponse
import com.home.dev.weather.mvp.model.entity.room.RoomWeather

object WeatherFactory {
    fun createMyWeather(response: WeatherResponse): MyWeather {
        return MyWeather(
            response.main.temp,
            response.main.humidity,
            response.wind.speed,
            response.main.pressure,
            response.dt,
            if (response.weather.isNotEmpty()) response.weather.first().icon else null
        )
    }

    fun createMyWeather(roomWeather: RoomWeather): MyWeather {
        return MyWeather(
            roomWeather.temp,
            roomWeather.humidity,
            roomWeather.windSpeed,
            roomWeather.pressure,
            roomWeather.dt,
            roomWeather.pathIcon
        )
    }

    fun createRoomWether(city: String, weather: MyWeather): RoomWeather {
        return RoomWeather(
            city,
            weather.temp,
            weather.humidity,
            weather.windSpeed,
            weather.pressure,
            weather.dt,
            weather.pathIcon
        )
    }
}