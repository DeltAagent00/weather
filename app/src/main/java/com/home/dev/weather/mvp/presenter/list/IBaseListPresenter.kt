package com.home.dev.weather.mvp.presenter.list

import com.home.dev.weather.mvp.view.list.IBaseListRowView

interface IBaseListPresenter<T: IBaseListRowView> {
    fun getCount(): Int
    fun bind(view: T)
}