package com.home.dev.weather.mvp.model.repo

import com.home.dev.weather.mvp.model.api.IApiService
import com.home.dev.weather.mvp.model.api.INetworkStatus
import com.home.dev.weather.mvp.model.cache.ICache
import com.home.dev.weather.mvp.model.entity.MyWeather
import com.home.dev.weather.mvp.model.entity.WeatherFactory
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class WeatherRepoImpl(private val apiService: IApiService,
                      private val cache: ICache,
                      private val networkStatus: INetworkStatus): IWeatherRepo {
    override fun getWeatherByCity(city: String): Single<MyWeather> {
        return if (networkStatus.isOnline()) {
            apiService.getWeather(city, "metric")
                .subscribeOn(Schedulers.io())
                .map {
                    val weather = WeatherFactory.createMyWeather(it)
                    cache.putWeather(city, weather).subscribe()
                    weather
                }
        } else {
            cache.getWeather(city)
        }
    }
}