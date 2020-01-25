package com.home.dev.weather.di.module

import android.content.Context
import androidx.room.Room
import com.home.dev.weather.mvp.model.cache.ICache
import com.home.dev.weather.mvp.model.cache.RoomCache
import com.home.dev.weather.mvp.model.entity.room.dao.db.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class CacheModule {
    @Singleton
    @Provides
    open fun provideRoomDatabase(context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, Database.DB_NAME).build()
    }

    @Singleton
    @Provides
    fun provideRoomCache(database: Database): ICache {
        return RoomCache(database)
    }
}