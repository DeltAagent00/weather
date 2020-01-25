package com.home.dev.weather.mvp.model.repo

import com.home.dev.weather.mvp.model.entity.MyWeather
import com.home.dev.weather.mvp.model.entity.openWeather.Item
import io.reactivex.Single

interface IWeatherRepo {
    fun getWeatherByCity(city: String): Single<MyWeather>
}