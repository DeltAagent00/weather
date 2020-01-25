package com.home.dev.weather.di.component

import com.home.dev.weather.di.module.*
import com.home.dev.weather.ui.mainScreen.MainActivity
import com.home.dev.weather.ui.mainScreen.MainPresenterImpl
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RetrofitModule::class, UtilsModule::class, RepoModule::class,
    CacheModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(presenter: MainPresenterImpl)
}