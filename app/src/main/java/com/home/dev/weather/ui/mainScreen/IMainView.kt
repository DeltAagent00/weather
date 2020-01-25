package com.home.dev.weather.ui.mainScreen

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.home.dev.weather.mvp.model.entity.MyWeather
import com.home.dev.weather.mvp.view.IBaseView

@StateStrategyType(SingleStateStrategy::class)
interface IMainView: IBaseView {
    fun initView()
    fun setIcon(url: String?)
    fun setTemperature(temp: String?)
    fun setHumidity(humidity: String?)
    fun setWindSpeed(windSpeed: String?)
    fun setPressure(pressure: String?)
    fun showCard()
}