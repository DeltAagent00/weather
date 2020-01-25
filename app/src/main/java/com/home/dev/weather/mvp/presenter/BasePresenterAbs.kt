package com.home.dev.weather.mvp.presenter

import androidx.annotation.CallSuper
import androidx.annotation.StringRes
import androidx.annotation.UiThread
import com.arellomobile.mvp.MvpPresenter
import com.home.dev.weather.mvp.view.IBaseView
import com.home.dev.weather.mvp.view.IStrings
import io.reactivex.disposables.Disposable

abstract class BasePresenterAbs<T: IBaseView>(private val strings: IStrings): MvpPresenter<T>(), IBasePresenter {

    private val unSubscribeList: HashSet<Disposable> = HashSet()

    @CallSuper
    override fun onStop() {
        unSubscribe()
    }

    private fun unSubscribe() {
        unSubscribeList.forEach {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    protected fun addSubscribe(subscribe: Disposable) {
        unSubscribeList.add(subscribe)
    }

    @UiThread
    protected fun closeScreen() {
        viewState.closeScreen()
    }

    @UiThread
    protected fun closeAffinityScreen() {
        viewState.closeAffinityScreen()
    }

    @UiThread
    protected fun lockScreen() {
        viewState.lockScreen()
    }

    @UiThread
    protected fun unlockScreen() {
        viewState.unlockScreen()
    }

    @UiThread
    protected fun showMessage(@StringRes message: Int) {
        viewState.showMessage(message)
    }

    @UiThread
    protected fun showMessage(message: CharSequence) {
        viewState.showMessage(message)
    }

    @UiThread
    protected fun showError(@StringRes errorMessage: Int) {
        viewState.showError(errorMessage)
    }

    @UiThread
    protected fun showError(errorMessage: CharSequence) {
        viewState.showError(errorMessage)
    }

    protected fun checkInternetShowError(isOnline: Boolean): Boolean {
        if (!isOnline) {
            showErrorInternet()
        }
        return isOnline
    }

    protected fun showErrorInternet() {
        showError(strings.getNoInternet())
    }

    protected fun showErrorServer() {
        showError(strings.getServerProblem())
    }

    protected fun showUnknownError() {
        showError(strings.getUnknownError())
    }
}