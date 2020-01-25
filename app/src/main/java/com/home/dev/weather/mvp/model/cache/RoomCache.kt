package com.home.dev.weather.mvp.model.cache

import com.home.dev.weather.mvp.model.entity.MyWeather
import com.home.dev.weather.mvp.model.entity.WeatherFactory
import com.home.dev.weather.mvp.model.entity.room.dao.db.Database
import io.reactivex.*
import io.reactivex.schedulers.Schedulers

class RoomCache(private val database: Database): ICache {
    override fun getWeather(city: String): Single<MyWeather> {
        return Single.create(SingleOnSubscribe<MyWeather> {
            val roomWeather = database.getWeatherDao().findByCity(city)

            if (roomWeather == null) {
                it.onError(RuntimeException("No such weather in cache"))
            } else {
                it.onSuccess(
                    WeatherFactory.createMyWeather(roomWeather)
                )
            }
        }).subscribeOn(Schedulers.io())
    }

    override fun putWeather(city: String, weather: MyWeather): Completable {
        return Completable.fromAction {
            val roomWeather = WeatherFactory.createRoomWether(city, weather)
            database.getWeatherDao().insert(roomWeather)
        }
    }
}