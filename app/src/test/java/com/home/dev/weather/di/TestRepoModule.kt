package com.home.dev.weather.di

import com.home.dev.weather.mvp.model.repo.IWeatherRepo
import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import javax.inject.Singleton

@Module
open class TestRepoModule {
    @Singleton
    @Provides
    open fun provideWeatherRepo(): IWeatherRepo {
        return Mockito.mock(IWeatherRepo::class.java)

    }
}