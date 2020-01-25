package com.home.dev.weather.ui

import android.content.Context
import android.net.ConnectivityManager
import com.home.dev.weather.mvp.model.api.INetworkStatus

class NetworkStatusImpl(private val context: Context): INetworkStatus {
    override fun getStatus(): INetworkStatus.Status {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (null != activeNetwork) {
            when (activeNetwork.type) {
                ConnectivityManager.TYPE_WIFI -> return INetworkStatus.Status.WIFI
                ConnectivityManager.TYPE_ETHERNET -> return INetworkStatus.Status.ETHERNET
                ConnectivityManager.TYPE_MOBILE -> return INetworkStatus.Status.MOBILE
            }
            return INetworkStatus.Status.OTHER
        }
        return INetworkStatus.Status.OFFLINE
    }

    override fun isOnline(): Boolean {
        return getStatus() != INetworkStatus.Status.OFFLINE
    }

    override fun isWifi(): Boolean {
        return getStatus() == INetworkStatus.Status.WIFI
    }

    override fun isEthernet(): Boolean {
        return getStatus() == INetworkStatus.Status.ETHERNET
    }

    override fun isMobile(): Boolean {
        return getStatus() == INetworkStatus.Status.MOBILE
    }

    override fun isOffline(): Boolean {
        return getStatus() == INetworkStatus.Status.OFFLINE
    }
}