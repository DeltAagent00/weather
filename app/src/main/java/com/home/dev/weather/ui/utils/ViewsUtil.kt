package com.home.dev.weather.ui.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView

object ViewsUtil {
    fun clearImageView(vararg imageViews: ImageView?) {
        clearColorFilterImageView(*imageViews)
        for (iv in imageViews)
            iv?.setImageResource(android.R.color.transparent)
    }

    fun clearColorFilterImageView(vararg imageViews: ImageView?) {
        for (iv in imageViews)
            iv?.colorFilter = null
    }

    fun clearTextViews(vararg textViews: TextView?) {
        for (tv in textViews) {
            tv?.text = ""
        }
    }

    fun goneViews(vararg views: View?) {
        for (v in views) {
            if (v?.visibility != View.GONE) {
                v?.visibility = View.GONE
            }
        }
    }

    fun hideViews(vararg views: View?) {
        for (v in views) {
            if (v?.visibility != View.INVISIBLE) {
                v?.visibility = View.INVISIBLE
            }
        }
    }

    fun showViews(vararg views: View?) {
        for (v in views) {
            if (v?.visibility != View.VISIBLE) {
                v?.visibility = View.VISIBLE
            }
        }
    }

    fun hideSoftKeyboard(view: View?) {
        view?.let {
            val inputMethodManager = it.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}