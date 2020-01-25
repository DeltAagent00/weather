package com.home.dev.weather

import android.content.Context
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.home.dev.weather.di.DaggerTestComponentInstrumented
import com.home.dev.weather.di.module.AppModule
import com.home.dev.weather.di.module.CacheModule
import com.home.dev.weather.mvp.model.cache.ICache
import com.home.dev.weather.mvp.model.entity.MyWeather
import com.home.dev.weather.mvp.model.entity.room.dao.db.Database
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertEquals
import org.junit.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
open class RoomCacheInstrumentedTest {
    companion object {
        @Inject
        lateinit var cache: ICache

        @BeforeClass
        fun setupClass() {
            Timber.plant(Timber.DebugTree())
            Timber.d("setupClass")
        }

        @AfterClass
        fun teardownClass() {
            Timber.d("tearDownClass")
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Before
    fun setup() {
        Timber.d("setup")
        val component = DaggerTestComponentInstrumented.builder()
            .appModule(AppModule(InstrumentationRegistry.getInstrumentation().targetContext))
            .cacheModule(object: CacheModule() {
                override fun provideRoomDatabase(context: Context): Database {
                    return Room.inMemoryDatabaseBuilder(context, Database::class.java).build()
                }
            })
            .build()
        component.inject(this)
    }

    @After
    fun tearDown() {
        Timber.d("tearDown")
    }

    @Test
    fun cacheWeather() {
        val city = "Moscow"
        val myWeather = MyWeather(1.0, 2, 3.0, 4.0, 5, "icon")

        cache.putWeather(city, myWeather).subscribe()

        val observer: TestObserver<MyWeather> = TestObserver()
        cache.getWeather(city).subscribe(observer)

        observer.awaitTerminalEvent()

        observer.assertValueCount(1)
        assertEquals(observer.values()[0].temp, myWeather.temp)
        assertEquals(observer.values()[0].humidity, myWeather.humidity)
        assertEquals(observer.values()[0].windSpeed, myWeather.windSpeed)
        assertEquals(observer.values()[0].pressure, myWeather.pressure)
        assertEquals(observer.values()[0].dt, myWeather.dt)
        assertEquals(observer.values()[0].pathIcon, myWeather.pathIcon)
    }
}
