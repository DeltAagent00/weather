package com.home.dev.weather.ui.mainScreen

import com.arellomobile.mvp.InjectViewState
import com.home.dev.weather.di.Injector
import com.home.dev.weather.mvp.model.entity.MyWeather
import com.home.dev.weather.mvp.model.repo.IWeatherRepo
import com.home.dev.weather.mvp.presenter.BasePresenterAbs
import com.home.dev.weather.mvp.view.IStrings
import io.reactivex.Scheduler
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
open class MainPresenterImpl(private val strings: IStrings,
                        private val mainThreadScheduler: Scheduler
): BasePresenterAbs<IMainView>(strings), IMainPresenter {
    @Inject
    lateinit var weatherRepo: IWeatherRepo

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initView()
    }

    override fun onClickGetWeather(city: String) {
        if (!isValidCity(city)) {
            showError(strings.getNotBeEmptyCity())
            return
        }

//        viewState.hideSoftKeyboard() // не понимаю почему не работает, viewState.lockScreen() точно также и работает
        viewState.lockScreen()

        addSubscribe(
            weatherRepo.getWeatherByCity(city)
                .observeOn(mainThreadScheduler)
                .subscribe(
                    {
                        fillCard(it)
                        viewState.unlockScreen()
                    },
                    {
                        Timber.e(it)
                        showError(strings.getServerProblem())
                        viewState.unlockScreen()
                    }
                )
        )
    }

    override fun onStart() {
    }

    fun isValidCity(city: String): Boolean {
        return city.isNotEmpty()
    }

    private fun fillCard(weather: MyWeather) {
        val urlIcon = weather.pathIcon?.let {
            strings.getUrlIcon(it)
        }
        viewState.setIcon(urlIcon)

        viewState.setTemperature(strings.getValueTemperature(weather.temp))
        viewState.setHumidity(strings.getValueHumidity(weather.humidity))
        viewState.setWindSpeed(strings.getValueWindSpeed(weather.windSpeed))
        viewState.setPressure(strings.getValuePressure(weather.pressure))

        viewState.showCard()
    }
}