package com.home.dev.weather.mvp.model.image

import androidx.annotation.DrawableRes

interface IImageLoader<T> {
    fun loadInto(url: String?, container: T, @DrawableRes defaultImage: Int = 0)
}