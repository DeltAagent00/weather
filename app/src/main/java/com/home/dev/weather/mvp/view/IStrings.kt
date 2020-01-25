package com.home.dev.weather.mvp.view

interface IStrings {
    fun getNoInternet(): String
    fun getServerProblem(): String
    fun getUnknownError(): String
    fun getNotBeEmptyCity(): String

    fun getTitleTemperature(): String
    fun getTitleHumidity(): String
    fun getTitleWindSpeed(): String
    fun getTitlePressure(): String

    fun getValueTemperature(value: Double): String
    fun getValueHumidity(value: Int): String
    fun getValueWindSpeed(value: Double): String
    fun getValuePressure(value: Double): String

    fun getUrlIcon(iconName: String): String
}