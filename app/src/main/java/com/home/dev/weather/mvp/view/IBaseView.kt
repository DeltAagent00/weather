package com.home.dev.weather.mvp.view

import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface IBaseView: MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun closeScreen()
    @StateStrategyType(SkipStrategy::class)
    fun closeAffinityScreen()
    @StateStrategyType(SkipStrategy::class)
    fun lockScreen()
    @StateStrategyType(SkipStrategy::class)
    fun hideSoftKeyboard()
    @StateStrategyType(SkipStrategy::class)
    fun unlockScreen()
    @StateStrategyType(SkipStrategy::class)
    fun showMessage(@StringRes message: Int)
    @StateStrategyType(SkipStrategy::class)
    fun showMessage(message: CharSequence)
    @StateStrategyType(SkipStrategy::class)
    fun showError(@StringRes errorMessage: Int)
    @StateStrategyType(SkipStrategy::class)
    fun showError(errorMessage: CharSequence)
}