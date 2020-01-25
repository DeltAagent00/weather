package com.home.dev.weather.mvp.model.api

import com.home.dev.weather.mvp.model.api.response.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val WEATHER_HEADER_ACCESS = "x-api-key"
    }

    @GET("data/2.5/weather")
    fun getWeather(@Query("q") city: String,
                   @Query("units") unit: String): Single<WeatherResponse>
}