package com.home.dev.weather.ui.mainScreen

import android.os.Bundle
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.facebook.drawee.view.SimpleDraweeView
import com.home.dev.weather.R
import com.home.dev.weather.di.Injector
import com.home.dev.weather.mvp.model.image.IImageLoader
import com.home.dev.weather.mvp.view.IStrings
import com.home.dev.weather.ui.AndroidStrings
import com.home.dev.weather.ui.activity.BaseActivityAbs
import com.home.dev.weather.ui.utils.ViewsUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity: BaseActivityAbs(), IMainView {
    @InjectPresenter
    lateinit var presenter: MainPresenterImpl

    @Inject
    lateinit var imageLoader: IImageLoader<SimpleDraweeView>

    private lateinit var strings: IStrings

    @ProvidePresenter
    fun providePresenter(): MainPresenterImpl {
        strings = AndroidStrings(this)
        val presenter = MainPresenterImpl(strings, AndroidSchedulers.mainThread())
        Injector.getInstance().appComponent().inject(presenter)
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Injector.getInstance().appComponent().inject(this)
    }

    override fun initView() {
        ViewsUtil.goneViews(cardView)

        btnActionView.setOnClickListener {
            presenter.onClickGetWeather(textEditView.text.toString().toLowerCase(Locale.getDefault()))
            hideSoftKeyboard()
        }
    }

    override fun setIcon(url: String?) {
        imageLoader.loadInto(url, iconWeatherView, R.drawable.ic_cloud_circle_black_24dp)
    }

    override fun setTemperature(temp: String?) {
        val textView: TextView = temperatureView.findViewById(R.id.title)
        val valueView: TextView = temperatureView.findViewById(R.id.value)

        textView.text = strings.getTitleTemperature()
        valueView.text = temp
    }

    override fun setHumidity(humidity: String?) {
        val textView: TextView = humidityView.findViewById(R.id.title)
        val valueView: TextView = humidityView.findViewById(R.id.value)

        textView.text = strings.getTitleHumidity()
        valueView.text = humidity
    }

    override fun setWindSpeed(windSpeed: String?) {
        val textView: TextView = windSpeedView.findViewById(R.id.title)
        val valueView: TextView = windSpeedView.findViewById(R.id.value)

        textView.text = strings.getTitleWindSpeed()
        valueView.text = windSpeed
    }

    override fun setPressure(pressure: String?) {
        val textView: TextView = pressureView.findViewById(R.id.title)
        val valueView: TextView = pressureView.findViewById(R.id.value)

        textView.text = strings.getTitlePressure()
        valueView.text = pressure
    }

    override fun showCard() {
        ViewsUtil.showViews(cardView)
    }
}
