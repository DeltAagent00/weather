package com.home.dev.weather.ui

import android.content.Context
import com.home.dev.weather.R
import com.home.dev.weather.mvp.view.IStrings

class AndroidStrings(private val context: Context): IStrings {
    override fun getNoInternet(): String {
        return context.getString(R.string.alert_internet_problem)
    }

    override fun getServerProblem(): String {
        return context.getString(R.string.unknown_server_error)
    }

    override fun getUnknownError(): String {
        return context.getString(R.string.unknown_error)
    }

    override fun getNotBeEmptyCity(): String {
        return context.getString(R.string.not_be_empty_city)
    }

    override fun getTitleTemperature(): String {
        return context.getString(R.string.temperature)
    }

    override fun getTitleHumidity(): String {
        return context.getString(R.string.humidity)
    }

    override fun getTitleWindSpeed(): String {
        return context.getString(R.string.wind_speed)
    }

    override fun getTitlePressure(): String {
        return context.getString(R.string.pressure)
    }

    override fun getValueTemperature(value: Double): String {
        return context.getString(R.string.temperature_value, value)
    }

    override fun getValueHumidity(value: Int): String {
        return context.getString(R.string.humidity_value, value)
    }

    override fun getValueWindSpeed(value: Double): String {
        return context.getString(R.string.wind_speed_value, value)
    }

    override fun getValuePressure(value: Double): String {
        return context.getString(R.string.pressure_value, value)
    }

    override fun getUrlIcon(iconName: String): String {
        return context.getString(R.string.url_icon, iconName)
    }
}