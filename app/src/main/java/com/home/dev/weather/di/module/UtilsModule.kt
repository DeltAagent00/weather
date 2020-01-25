package com.home.dev.weather.di.module

import android.content.Context
import com.facebook.drawee.view.SimpleDraweeView
import com.home.dev.weather.mvp.model.api.INetworkStatus
import com.home.dev.weather.mvp.model.image.IImageLoader
import com.home.dev.weather.ui.NetworkStatusImpl
import com.home.dev.weather.ui.image.FrescoImageLoaderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun provideNetworkUtils(context: Context): INetworkStatus {
        return NetworkStatusImpl(context)
    }

    @Provides
    @Singleton
    fun provideImageLoader(): IImageLoader<SimpleDraweeView> {
        return FrescoImageLoaderImpl()
    }
}