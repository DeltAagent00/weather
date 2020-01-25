package com.home.dev.weather.di.module

import com.home.dev.weather.mvp.model.api.IApiService
import com.home.dev.weather.mvp.model.api.INetworkStatus
import com.home.dev.weather.mvp.model.cache.ICache
import com.home.dev.weather.mvp.model.repo.IWeatherRepo
import com.home.dev.weather.mvp.model.repo.WeatherRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Provides
    @Singleton
    fun provideWeatherRepo(apiService: IApiService, cache: ICache, networkStatus: INetworkStatus): IWeatherRepo {
        return WeatherRepoImpl(apiService, cache, networkStatus)
    }
}