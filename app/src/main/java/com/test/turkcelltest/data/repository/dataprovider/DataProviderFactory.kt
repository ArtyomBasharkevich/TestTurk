package com.test.turkcelltest.data.repository.dataprovider

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.getSystemService
import com.test.turkcelltest.data.cache.Cache
import com.test.turkcelltest.data.network.RestApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataProviderFactory @Inject constructor(
    private val context: Context,
    private val cache: Cache,
    private val restApiService: RestApiService
) {

    val dataProvider: DataProvider
        get() = if (hasInternetConnection()) {
            restApiService
        } else {
            cache
        }

    private fun hasInternetConnection(): Boolean {
        var result = false
        context.getSystemService<ConnectivityManager>()?.run {
            this.getNetworkCapabilities(this.activeNetwork)?.run {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            }
        }
        return result
    }
}