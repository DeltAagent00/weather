package com.home.dev.weather.mvp.model.cache

import com.home.dev.weather.mvp.model.entity.MyWeather
import io.reactivex.Completable
import io.reactivex.Single

interface ICache {
    fun getWeather(city: String): Single<MyWeather>
    fun putWeather(city: String, weather: MyWeather): Completable
}