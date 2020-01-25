package com.home.dev.weather.ui.image

import androidx.annotation.DrawableRes
import com.facebook.drawee.view.SimpleDraweeView
import com.home.dev.weather.mvp.model.image.IImageLoader

class FrescoImageLoaderImpl: IImageLoader<SimpleDraweeView> {
    override fun loadInto(url: String?, container: SimpleDraweeView, @DrawableRes defaultImage: Int) {
        if (defaultImage != 0) {
            container.hierarchy.setPlaceholderImage(defaultImage)
        }
        container.setImageURI(url, null)
    }
}