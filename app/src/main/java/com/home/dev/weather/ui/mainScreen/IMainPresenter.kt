package com.home.dev.weather.ui.mainScreen

import com.home.dev.weather.mvp.presenter.IBasePresenter

interface IMainPresenter: IBasePresenter {
    fun onClickGetWeather(city: String)
}