package com.home.dev.weather.di

import com.home.dev.weather.RoomCacheInstrumentedTest
import com.home.dev.weather.di.module.AppModule
import com.home.dev.weather.di.module.RepoModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepoModule::class])
interface TestComponentInstrumented {
    fun inject(test: RoomCacheInstrumentedTest)
}