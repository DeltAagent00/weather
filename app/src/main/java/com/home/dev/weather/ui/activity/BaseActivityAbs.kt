package com.home.dev.weather.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.home.dev.weather.R
import com.home.dev.weather.mvp.view.IBaseView
import com.home.dev.weather.ui.utils.ViewsUtil

abstract class BaseActivityAbs: MvpAppCompatActivity(), IBaseView {
    private var lockScreen: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLockScreen()
    }

    override fun closeScreen() {
        finish()
    }

    override fun closeAffinityScreen() {
        finishAffinity()
    }

    override fun lockScreen() {
        ViewsUtil.showViews(lockScreen)
    }

    override fun hideSoftKeyboard() {
        ViewsUtil.hideSoftKeyboard(window.decorView)
    }

    override fun unlockScreen() {
        ViewsUtil.goneViews(lockScreen)
    }

    override fun showMessage(message: Int) {
        if (message != 0) {
            showMessage(getString(message))
        }
    }

    override fun showMessage(message: CharSequence) {
        showToast(message)
    }

    override fun showError(errorMessage: Int) {
        if (errorMessage != 0) {
            showError(getString(errorMessage))
        }
    }

    override fun showError(errorMessage: CharSequence) {
        showToast(errorMessage)
    }

    private fun showToast(message: CharSequence) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun initLockScreen() {
        lockScreen = LayoutInflater.from(this).inflate(R.layout.lock_screen, null) as ViewGroup
        ViewsUtil.goneViews(lockScreen)
        (window.decorView as ViewGroup).addView(lockScreen)
    }
}