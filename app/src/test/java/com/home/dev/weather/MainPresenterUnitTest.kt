package com.home.dev.weather

import com.home.dev.weather.di.DaggerTestComponent
import com.home.dev.weather.di.TestRepoModule
import com.home.dev.weather.mvp.model.entity.MyWeather
import com.home.dev.weather.mvp.model.repo.IWeatherRepo
import com.home.dev.weather.mvp.view.IStrings
import com.home.dev.weather.ui.mainScreen.IMainView
import com.home.dev.weather.ui.mainScreen.MainPresenterImpl
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 */
class MainPresenterUnitTest {
    companion object {
        private lateinit var presenter: MainPresenterImpl
        private lateinit var testScheduler: TestScheduler
        private val strings = object : IStrings {
            override fun getNoInternet(): String {
                return ""
            }

            override fun getServerProblem(): String {
                return ""
            }

            override fun getUnknownError(): String {
                return ""
            }

            override fun getNotBeEmptyCity(): String {
                return ""
            }

            override fun getTitleTemperature(): String {
                return ""
            }

            override fun getTitleHumidity(): String {
                return ""
            }

            override fun getTitleWindSpeed(): String {
                return ""
            }

            override fun getTitlePressure(): String {
                return ""
            }

            override fun getValueTemperature(value: Double): String {
                return ""
            }

            override fun getValueHumidity(value: Int): String {
                return ""
            }

            override fun getValueWindSpeed(value: Double): String {
                return ""
            }

            override fun getValuePressure(value: Double): String {
                return ""
            }

            override fun getUrlIcon(iconName: String): String {
                return iconName
            }
        }

        @Mock
        lateinit var mainView: IMainView

        @BeforeClass
        fun setupClass() {
            Timber.plant(DebugTree())
            Timber.d("setupClass")
        }

        @AfterClass
        fun teardownClass() {
            Timber.d("tearDownClass")
        }
    }

    @Before
    fun setup() {
        Timber.d("setup")
        MockitoAnnotations.initMocks(this)
        testScheduler = TestScheduler()
        presenter = Mockito.spy(MainPresenterImpl(strings, testScheduler))
    }

    @After
    fun tearDown() {
        Timber.d("tearDown")
    }

    @Test
    fun loadDataSuccess() {
        val city = "Moscow"
        val myWeather = MyWeather(1.0, 2, 3.0, 4.0, 5, "icon")

        val component = DaggerTestComponent.builder()
            .testRepoModule(object: TestRepoModule() {
                override fun provideWeatherRepo(): IWeatherRepo {
                    val repo = super.provideWeatherRepo()
                    Mockito.`when`(repo.getWeatherByCity(city)).thenReturn(Single.just(myWeather))
                    return repo
                }
            })
            .build()

        component.inject(presenter)

        presenter.attachView(mainView)
        Mockito.verify(mainView).initView()

        presenter.onClickGetWeather(city)
//        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS)

//        Mockito.verify(mainView, Mockito.times(1)).lockScreen()
        Mockito.verify(mainView).lockScreen()
        val urlIcon = strings.getUrlIcon(myWeather.pathIcon!!)
        Mockito.verify(mainView).setIcon(urlIcon)
        Mockito.verify(mainView).setTemperature(strings.getValueTemperature(myWeather.temp))
        Mockito.verify(mainView).setHumidity(strings.getValueHumidity(myWeather.humidity))
        Mockito.verify(mainView).setWindSpeed(strings.getValueWindSpeed(myWeather.windSpeed))
        Mockito.verify(mainView).setPressure(strings.getValuePressure(myWeather.pressure))
        Mockito.verify(mainView).showCard()
        Mockito.verify(mainView).unlockScreen()
    }

    @Test
    fun loadDataFailure() {
        val city = "Moscow"
        val myWeather = MyWeather(1.0, 2, 3.0, 4.0, 5, "icon")
        val errorMessage = "network error"
        val component = DaggerTestComponent.builder()
            .testRepoModule(object: TestRepoModule() {
                override fun provideWeatherRepo(): IWeatherRepo {
                    val repo = super.provideWeatherRepo()
                    Mockito.`when`(repo.getWeatherByCity(city)).thenReturn(Single.error(Exception(errorMessage)))
                    return repo
                }
            })
            .build()

        component.inject(presenter)

        presenter.attachView(mainView)
        Mockito.verify(mainView).initView()

        presenter.onClickGetWeather(city)
//        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS)

//        Mockito.verify(mainView, Mockito.times(1)).lockScreen()
        Mockito.verify(mainView).lockScreen()
        Mockito.verify(mainView).showError(strings.getServerProblem())

        Mockito.verify(mainView).unlockScreen()
    }
}
