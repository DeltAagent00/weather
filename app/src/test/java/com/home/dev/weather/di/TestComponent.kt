package com.home.dev.weather.di

import com.home.dev.weather.ui.mainScreen.MainPresenterImpl
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestRepoModule::class])
interface TestComponent {
    fun inject(presenter: MainPresenterImpl)
}