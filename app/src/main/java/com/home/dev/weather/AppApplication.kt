package com.home.dev.weather

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.home.dev.weather.di.Injector
import timber.log.Timber

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initTimber()
        Injector.getInstance().init(this)
        initFresco()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(Timber.asTree())
        }
    }

    private fun initFresco() {
        Fresco.initialize(this)
    }
}